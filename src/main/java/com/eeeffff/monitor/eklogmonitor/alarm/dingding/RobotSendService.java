package com.eeeffff.monitor.eklogmonitor.alarm.dingding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.RobotSendRequest;
import com.eeeffff.monitor.eklogmonitor.common.enums.RobotMsgTypeEnum;

import lombok.extern.slf4j.Slf4j;

/**
 * 钉钉机器人发送接口工具类
 * 
 * @author fenglibin
 *
 */
@Slf4j
@Service
public class RobotSendService {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 发送机器人消息
	 * 
	 * @param url
	 * @param request
	 * @return
	 */
	public JSONObject sendRequestToRobot(String url, RobotSendRequest request) {
		log.info("钉钉机器人发送请求url:{}", url);
		log.info("钉钉机器人发送请求原始参数:{}", JSON.toJSONString(request));
		populateAtMobile(request);
		log.info("钉钉机器人发送请求转换后参数:{}", JSON.toJSONString(request));
		JSONObject ddResult = null;
		try {
			ddResult = restTemplate.postForObject(url, request, JSONObject.class);
			log.info("钉钉机器人发送请求响应:{}", ddResult);
		} catch (Exception e) {
			String strResult = restTemplate.postForObject(url, request, String.class);
			log.error("发生请求到钉钉机器发生异常：" + e.getMessage() + "，响应内容为：" + strResult, e);
		}
		return ddResult;
	}

	/**
	 * 根据@人的手机号码列表在推送内容中填充@人手机号码信息
	 * 
	 * @param request
	 */
	private void populateAtMobile(RobotSendRequest request) {
		if (request.getMsgtype().equals(RobotMsgTypeEnum.TEXT.getText())) {
			if (null == request.getText()) {
				return;
			}
			RobotSendRequest.Text text = request.getText();
			StringBuilder content = new StringBuilder();
			content.append(text.getContent());
			if (null == request.getAt()) {
				return;
			}
			RobotSendRequest.At at = request.getAt();
			if (!at.getAtMobiles().isEmpty()) {
				at.getAtMobiles().forEach(mobile -> content.append(" @").append(mobile).append(" "));
			}
			text.setContent(content.toString());
		} else if (request.getMsgtype().equals(RobotMsgTypeEnum.MARKDOWN.getText())) {
			if (null == request.getMarkdown()) {
				return;
			}
			RobotSendRequest.MarkDown markDown = request.getMarkdown();
			if (null == request.getAt()) {
				return;
			}
			RobotSendRequest.At at = request.getAt();
			StringBuilder content = new StringBuilder();
			content.append(markDown.getText());
			if (at.getAtMobiles() != null && !at.getAtMobiles().isEmpty()) {
				at.getAtMobiles().forEach(mobile -> content.append(" @").append(mobile).append(" "));
			}
			markDown.setText(content.toString());
		}
	}
}