package com.eeeffff.monitor.eklogmonitor.service.task;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eeeffff.monitor.eklogmonitor.alarm.AlarmAction;
import com.eeeffff.monitor.eklogmonitor.common.concurrent.NamedThreadFactory;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorData;
import com.eeeffff.monitor.eklogmonitor.service.config.AppMonitorProperties;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorConfigService;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorDataService;

import lombok.extern.slf4j.Slf4j;

/**
 * 应用ES异常监控定时任务
 * 
 * @author fenglibin
 *
 */
@Component
@Slf4j
public class AppMonitorJobHandler {

	public final static String ES_RESULT_HITS_NODE = "hits";

	public final static String ES_RESULT_HITS_TOTAL_NODE = "total";

	public final static String ES_RESULT_HITS_TOTAL_VALUE_NODE = "value";

	public final static String ES_START_TIME_PLACEHOLDER = "\\$\\{startTime\\}";

	public final static String ES_END_TIME_PLACEHOLDER = "\\$\\{endTime\\}";

	public final static String KIBANA_INDEX_PLACEHOLDER = "\\$\\{index\\}";

	public final static String KIBANA_ORIGINAL_QUERY_PLACEHOLDER = "\\$\\{original_query\\}";

	public final static String QUERY_PLACEHOLDER = "\\$\\{query\\}";

	public final static int UN_DELETE = 0;

	private LocalDateTime now = null;

	@Autowired
	private AppMonitorProperties appMonitorProperties;

	@Autowired
	@Qualifier("allowAllHttpsRestTemplate")
	private RestTemplate restTemplate;

	@Autowired
	private IAppMonitorConfigService appMonitorConfigService;

	@Autowired
	private IAppMonitorDataService appMonitorDataService;

	private ScheduledExecutorService fetchScheduleService;
	// 标识当前检查任务是否在运行
	private boolean taskRunning = false;

	@PostConstruct
	public void init() {
		fetchScheduleService = Executors.newScheduledThreadPool(1,
				new NamedThreadFactory("Auto do query search from ES task of EKLogMonitor", true));
		fetchScheduleService.scheduleAtFixedRate(() -> {
			try {
				startTask();
			} catch (Exception e) {
				log.error("fetchAndReportMetric error:", e);
			}
		}, 10, appMonitorProperties.getTaskIntervalSeconds(), TimeUnit.SECONDS);
	}

	public void startTask() {
		try {
			if(taskRunning) {
				return;
			}
			taskRunning = true;
			now = LocalDateTime.now();
			log.info("开始执行本次异常监控定时调度任务:" + now.toString());
			List<AppMonitorConfig> appMonitorConfigList = getAppMonitorConfigList();
			appMonitorConfigList.stream().forEach(config -> {
				do {
					if (config.getLastScanTime() != null
							&& config.getLastScanTime().plusMinutes(config.getExecuteCycle()).compareTo(now) > 0) {
						log.info("任务:" + config.getAppName() + "　的上次执行时间为:" + config.getLastScanTime() + "，其执行周期为:"
								+ config.getExecuteCycle() + "分钟，当前时间为:" + now + "，本次不需要执行.");
						return;
					}
					// 针对每条配置一直追到当前时间，保持监控的时效性
					try {
						log.info("开始执行异常监控定时调度任务:" + config.getAppName());
						invokeES(config);
						updateAppMonitorConfig(config);
						log.info("完成执行异常监控定时调度任务:" + config.getAppName());
					} catch (Exception e) {
						log.error("执行监控配置时发生异常，监控项名称：" + config.getAppName() + "，应用归属人：" + config.getAppOwner()
								+ "，异常信息：" + e.getMessage(), e);
					}
				} while (config.getLastScanTime().isBefore(now));
			});
			log.info("结束执行本次异常监控定时调度任务:" + LocalDateTime.now().toString());
		} catch (Exception e) {
			log.error("应用ES异常监控定时任务发生异常:" + e.getMessage(), e);
		} finally {
			taskRunning = false;
		}
	}

	/**
	 * 查询所有有效的监控配置列表
	 * 
	 * @return
	 */
	private List<AppMonitorConfig> getAppMonitorConfigList() {
		LambdaQueryWrapper<AppMonitorConfig> queryWrapper = new QueryWrapper<AppMonitorConfig>().lambda()
				.eq(AppMonitorConfig::getIsDel, UN_DELETE);
		return appMonitorConfigService.list(queryWrapper);
	}

	/**
	 * 更新配置中的lastScanTime
	 * 
	 * @param config
	 */
	private void updateAppMonitorConfig(AppMonitorConfig config) {
		config.setUpdateTime(null);
		appMonitorConfigService.updateById(config);
	}

	/**
	 * 持久化监控结果数据
	 * 
	 * @param data
	 */
	public void saveAppMonitorData(AppMonitorData data) {
		appMonitorDataService.save(data);
	}

	/**
	 * 调用ES获取结果
	 * 
	 * @param config
	 * @return
	 */
	private void invokeES(AppMonitorConfig config) {
		String url = assembleEsUrl(config.getEsIndex());
		log.info("Es查询请求url:{}", url);
		AppMonitorData data = parseEsParam(config);
		String esQuery = generateTargetEsParam(config.getEsParam(), data, false);
		JSONObject result;
		try {
			// 将查询模板与查询语句进行组装
			String esTemplate = appMonitorProperties.getEsTemplate();
			esTemplate = esTemplate.replaceAll(QUERY_PLACEHOLDER, esQuery);
			// 填充时间
			esTemplate = esTemplate.replaceAll(ES_START_TIME_PLACEHOLDER,
					data.getStartTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
			esTemplate = esTemplate.replaceAll(ES_END_TIME_PLACEHOLDER,
					data.getEndTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

			log.debug("Es查询请求的查询体:{}", esTemplate);

			result = restTemplate.postForObject(url, JSONObject.parse(esTemplate), JSONObject.class);
			log.debug("Es查询成功，响应结果为:{}", result);
			// 只要请求成功,就要刷新扫描时间
			config.setLastScanTime(data.getEndTime());
			handleEsResult(result, config, data);
		} catch (Exception e) {
			log.error("Es查询响应结果发生异常:" + e.getMessage(), e);
		}
	}

	/**
	 * 根据EsIndex组装查询的请求url
	 * 
	 * @param esIndex
	 * @return
	 */
	private String assembleEsUrl(String esIndex) {
		String uri = appMonitorProperties.select();
		if (StringUtils.isEmpty(uri)) {
			throw new IllegalArgumentException("ElasticSearch uri配置错误，请检查 es.uri-list 配置项");
		}
		StringBuilder url = new StringBuilder();
		url.append(uri).append(esIndex).append("/_search");
		return url.toString();
	}

	/**
	 * 解析Es参数
	 * 
	 * @param config
	 * @return
	 */
	private AppMonitorData parseEsParam(AppMonitorConfig config) {
		AppMonitorData data = new AppMonitorData();
		data.setConfigId(config.getId());
		// 如果上次扫描的时间大于了当前的系统时间，表示系统处理应该出错了，
		// 这里做纠正操作，将最后一次的处理时间
		if (null == config.getLastScanTime()) {
			// 如果最后一次的扫描时间为空，则将当前时间设置为最后一次的扫描时间，开始扫描时间为当前时间减去扫描间隔时间
			
			data.setStartTime(now.minusMinutes(config.getExecuteCycle()));
			data.setEndTime(now);
		} else if (now.compareTo(config.getLastScanTime()) <= 0) {
			// 设置本次的开始扫描时间为上次扫描的结束时间
			data.setStartTime(config.getLastScanTime());
			// 如果当前时间小于最后一次的扫描时间，则将当前的扫描截止时间设置为当前时间
			data.setEndTime(now);
		} else if (now.compareTo(config.getLastScanTime()) > 0) {
			// 设置本次的开始扫描时间为上次扫描的结束时间
			data.setStartTime(config.getLastScanTime());
			// 判断当前扫描的截止时间＋扫描的间隔后，是否大于当前的时间，如果大于当前时间则本次的扫描截止时间则设为当前时间
			if (now.compareTo(
					config.getLastScanTime().plusMinutes(config.getExecuteCycle())) < 0) {
				data.setEndTime(now);
			} else {
				data.setEndTime(config.getLastScanTime().plusMinutes(config.getExecuteCycle()));
			}
		}
		config.setLastScanTime(data.getEndTime());
		return data;
	}

	/**
	 * EsParam解析并填充实际的运行参数
	 * 
	 * @param sourceEsParam
	 * @param data
	 * @param append
	 * @return
	 */
	private String generateTargetEsParam(String sourceEsParam, AppMonitorData data, boolean append) {
		String esQuery = sourceEsParam;
		log.debug("Es查询请求来源参数:{}", esQuery);
		String targetStartTime = data.getStartTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		if (append) {
			targetStartTime = "'" + targetStartTime + "'";
		}
		String targetEndTime = data.getEndTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		if (append) {
			targetEndTime = "'" + targetEndTime + "'";
		}
		// 去掉最外层的query，如将{"query":{"bool":{"match_all":""}}}，只提取其中的{"bool":{"match_all":""}}
		esQuery = JSONObject.parseObject(esQuery).getJSONObject("query").toString();
		log.debug("Es查询请求目标参数:{}", esQuery);
		return esQuery;
	}

	/**
	 * 将Es的DSL语句转换为Kibana的KQL语法
	 * 
	 * @param config
	 * @param data
	 * @return
	 */
	public String generateTargetKibanaUrl(AppMonitorConfig config, AppMonitorData data) {
		String targetKibanaUrl = appMonitorProperties.getKibanaTemplate();

		// 填充时间
		targetKibanaUrl = targetKibanaUrl.replaceAll(ES_START_TIME_PLACEHOLDER,
				data.getStartTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		targetKibanaUrl = targetKibanaUrl.replaceAll(ES_END_TIME_PLACEHOLDER,
				data.getEndTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

		// 填充索引
		targetKibanaUrl = targetKibanaUrl.replaceAll(KIBANA_INDEX_PLACEHOLDER, config.getKibanaIndex());

		// 填充query
		String esQuery = generateTargetEsParam(config.getEsParam(), data, true);

		targetKibanaUrl = targetKibanaUrl.replaceAll(KIBANA_ORIGINAL_QUERY_PLACEHOLDER, esQuery);

		esQuery = esQuery.replaceAll("\\{", "(");
		esQuery = esQuery.replaceAll("\\[", "!(");
		esQuery = esQuery.replaceAll("\\}", ")");
		esQuery = esQuery.replaceAll("\\]", ")");
		// 对查询语句为 *abc* 这样的内容做处理(开始)
		esQuery = esQuery.replaceAll("\"\\*", "_SB_");
		esQuery = esQuery.replaceAll("\\*\"", "_SA_");
		esQuery = esQuery.replaceAll("\"", "");
		esQuery = esQuery.replaceAll("_SB_", "'\\*");
		esQuery = esQuery.replaceAll("_SA_", "\\*'");
		// 对查询语句为 *abc* 这样的内容做处理(结束)
		/*
		 * for (String kibanaKey : appMonitorProperties.getKibanaKeywordList()) {
		 * esQuery = esQuery.replaceAll(kibanaKey + ":", kibanaKey + ":!"); }
		 */
		targetKibanaUrl = targetKibanaUrl.replaceAll(QUERY_PLACEHOLDER, esQuery);

		log.info("Kibana目标地址:{}", targetKibanaUrl);
		return targetKibanaUrl;
	}

	/**
	 * 处理Es返回的结果
	 * 
	 * @param result
	 * @param config
	 * @param data
	 * @throws UnsupportedEncodingException
	 */
	private void handleEsResult(JSONObject result, AppMonitorConfig config, AppMonitorData data) {
		if (!result.containsKey(ES_RESULT_HITS_NODE)) {
			log.info("Es查询响应结果:{} 不包含hits节点,忽略告警", result);
			return;
		}
		JSONObject hits = result.getJSONObject(ES_RESULT_HITS_NODE);
		if (!hits.containsKey(ES_RESULT_HITS_TOTAL_NODE)) {
			log.info("Es查询响应结果:{} 不包含hits.total节点,忽略告警", result);
			return;
		}
		JSONObject total = hits.getJSONObject(ES_RESULT_HITS_TOTAL_NODE);
		int errCount = total.containsKey(ES_RESULT_HITS_TOTAL_VALUE_NODE)
				? total.getInteger(ES_RESULT_HITS_TOTAL_VALUE_NODE)
				: 0;
		if (errCount < config.getAlarmThreshold()) {
			log.info("Es查询响应结果:{} 匹配的文档数量为:{},忽略告警", result, errCount);
			return;
		}
		data.setErrCount(errCount);
		data.setKibanaUrl(generateTargetKibanaUrl(config, data));
		saveAppMonitorData(data);

		AlarmAction.executeAlarm(config, data);
	}
}