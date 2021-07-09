package com.eeeffff.monitor.eklogmonitor.alarm.dingding;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeeffff.monitor.eklogmonitor.alarm.AlarmAction;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.RobotSendRequest;
import com.eeeffff.monitor.eklogmonitor.common.enums.RobotMsgTypeEnum;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorData;
import com.eeeffff.monitor.eklogmonitor.service.config.AppMonitorProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * 钉钉告警
 * 
 * @author fenglibin
 *
 */
@Slf4j
@Service
public class DingDingAlarmAction extends AlarmAction {

	@Autowired
	private RobotSendService robotSendService;
	@Autowired
	private AppMonitorProperties appMonitorProperties;

	@Override
	public void doAlarm(AppMonitorConfig config, AppMonitorData data) {
		try {
			doDdRobotNotifyLink(config, data);
			doDdRobotNotifyAt(config, data);
			Thread.sleep((int) (60 / appMonitorProperties.getDdSendEveryMinute() * 2));
		} catch (Exception e) {
			log.error("发送请求到钉钉机器人发生异常：" + e.getMessage(), e);
		}
	}

	@Override
	public int getOrder() {
		return 0;
	}

	/**
	 * 发送钉钉通知-发送Kibana链接
	 * 
	 * @param config
	 * @param data
	 */
	private void doDdRobotNotifyLink(AppMonitorConfig config, AppMonitorData data) {
		RobotSendRequest robotSendRequest = new RobotSendRequest();
		robotSendRequest.setMsgtype(RobotMsgTypeEnum.LINK.getText());

		RobotSendRequest.At at = new RobotSendRequest.At();
		if (StringUtils.isBlank(config.getDdRobotMobile())) {
			at.setIsAtAll(true);
		} else {
			at.setIsAtAll(false);
			at.setAtMobiles(Arrays.asList(config.getDdRobotMobile().split(",")));
		}
		robotSendRequest.setAt(at);

		RobotSendRequest.Link link = new RobotSendRequest.Link();
		link.setTitle(config.getAppName());
		StringBuilder text = new StringBuilder();
		text.append("异常次数: ").append(data.getErrCount()).append(" 次 \n ").append("监控范围: ")
				.append(data.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).append("~")
				.append(data.getEndTime().format(DateTimeFormatter.ofPattern("HH:mm"))).append(" \n ").append("监控时间: ")
				.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM月dd日 HH点mm分"))).append("\n");
		link.setText(text.toString());
		link.setMessageUrl(data.getKibanaUrl());
		robotSendRequest.setLink(link);

		robotSendService.sendRequestToRobot(appMonitorProperties.getDdWebhookUrl() + config.getDdWebhookAccessToken(),
				robotSendRequest);
	}

	/**
	 * 发送@At消息到以应的人
	 * 
	 * @param config
	 * @param data
	 */
	private void doDdRobotNotifyAt(AppMonitorConfig config, AppMonitorData data) {
		RobotSendRequest robotSendRequest = new RobotSendRequest();
		robotSendRequest.setMsgtype(RobotMsgTypeEnum.MARKDOWN.getText());

		RobotSendRequest.At at = new RobotSendRequest.At();
		if (StringUtils.isBlank(config.getDdRobotMobile())) {
			at.setIsAtAll(true);
		} else {
			at.setIsAtAll(false);
			at.setAtMobiles(Arrays.asList(config.getDdRobotMobile().split(",")));
		}
		robotSendRequest.setAt(at);

		RobotSendRequest.MarkDown markDown = new RobotSendRequest.MarkDown();
		markDown.setTitle(config.getAppName());
		markDown.setText("请及时处理线上问题.");
		robotSendRequest.setMarkdown(markDown);

		robotSendService.sendRequestToRobot(appMonitorProperties.getDdWebhookUrl() + config.getDdWebhookAccessToken(),
				robotSendRequest);
	}

}
