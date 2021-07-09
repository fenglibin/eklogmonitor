package com.eeeffff.monitor.eklogmonitor.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.eeeffff.monitor.eklogmonitor.AbstractSpringBootTest;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorData;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorConfigService;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorDataService;
import com.eeeffff.monitor.eklogmonitor.service.task.AppMonitorJobHandler;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author fenglibin
 *
 */
@Slf4j
public class AppMonitorJobHandlerTest extends AbstractSpringBootTest {
	@Autowired
    @Qualifier("allowAllHttpsRestTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private AppMonitorJobHandler appMonitorJobHandler;
    
    @Autowired
    private IAppMonitorConfigService appMonitorConfigService;
    
    @Autowired
    private IAppMonitorDataService appMonitorDataService;

    @Test
    public void testExecute() throws Exception {
        appMonitorJobHandler.startTask();
    }
    
    @Test
    public void testExecuteEsQuery() {
    	String url = "https://172.16.60.101:9200/*erp-*/_search";
    	String esQuery = "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"message\":{\"value\":\"error\"}}},{\"range\":{\"@timestamp\":{\"gte\":\"2021-01-04T14:40:11\",\"lte\":\"2021-01-04T14:50:11\",\"time_zone\": \"Asia/Shanghai\"}}}],\"must_not\":[{\"term\":{\"message\":{\"value\":\"info\"}}}]}}}";
    	JSONObject result;
        try {
            result = restTemplate.postForObject(url, JSONObject.parse(esQuery), JSONObject.class);
        } catch (Exception e) {
            log.error("Es查询响应结果发生异常:"+e.getMessage(), e);
            return;
        }
        log.info("Es查询响应结果:{}", result);
    }
    
    @Test
    public void generateTargetEsParamTest() {
		List<String> esKeywordList = new ArrayList<String>();
		esKeywordList.add("must");
		esKeywordList.add("filter");
		esKeywordList.add("should");
		esKeywordList.add("must_not");
		String esQuery="{\"query\":{\"bool\":{\"must\":[{\"wildcard\":{\"message\":{\"value\":\"*nullpointerexception*\"}}}],\"must_not\":[{\"term\":{\"fields.service.keyword\":{\"value\":\"ld-erp-devops\"}}}]}}}";
		esQuery = JSONObject.parseObject(esQuery).getJSONObject("query").toString();
		esQuery = esQuery.replaceAll("\\{", "(");
		esQuery = esQuery.replaceAll("\\[", "(");
		esQuery = esQuery.replaceAll("\\}", ")");
		esQuery = esQuery.replaceAll("\\]", ")");
		// 对查询语句为 *abc*　这样的内容做处理(开始)
		esQuery = esQuery.replaceAll("\"\\*", "_SB_");
		esQuery = esQuery.replaceAll("\\*\"", "_SA_");
		esQuery = esQuery.replaceAll("\"", "");
		esQuery = esQuery.replaceAll("_SB_","'\\*");
		esQuery = esQuery.replaceAll("_SA_","\\*'");
		// 对查询语句为 *abc*　这样的内容做处理(开始)
		for (String kibanaKey : esKeywordList) {
			esQuery = esQuery.replaceAll(kibanaKey + ":", kibanaKey + ":!");
		}
		System.out.println(esQuery);
	}
    
    @Test
    public void generateTargetKibanaUrlTest() {
    	AppMonitorConfig config = appMonitorConfigService.getById(49L);
    	AppMonitorData data = new AppMonitorData();
    	data.setStartTime(LocalDateTime.parse("2021-02-01T08:11:00",DateTimeFormatter.ISO_DATE_TIME));
    	data.setEndTime(LocalDateTime.parse("2021-02-01T08:21:00",DateTimeFormatter.ISO_DATE_TIME));
    	String url = appMonitorJobHandler.generateTargetKibanaUrl(config, data);
    	System.out.println(url);
	}
}