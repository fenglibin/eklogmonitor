package com.eeeffff.monitor.eklogmonitor.alarm.phone;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeeffff.monitor.eklogmonitor.alarm.AlarmAction;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorData;
import com.eeeffff.monitor.eklogmonitor.service.config.AppMonitorProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * 电话告警
 * 
 * @author fenglibin
 *
 */
@Slf4j
@Service
public class PhoneAlarmAction extends AlarmAction {
	@Autowired
	private AppMonitorProperties appMonitorProperties;

	@Override
	public void doAlarm(AppMonitorConfig config, AppMonitorData data) {
		try {
			int errCount = data.getErrCount();
			if (errCount < config.getPhoneAlarmThreshold()) {
				return;
			}
			// 增加应用告警负责人的电话
			List<String> phoneList = new ArrayList<String>();
			String[] phoneArr = config.getDdRobotMobile().split(",");
			for (String phone : phoneArr) {
				phoneList.add(phone);
			}
			// 增加电话告警需要额外通知的用户
			String phoneAlertExtraUsers = appMonitorProperties.getPhoneAlertExtraUsers().get(config.getDeptId());
			if (!StringUtils.isEmpty(phoneAlertExtraUsers)) {
				phoneArr = phoneAlertExtraUsers.split(",");
				for (String phone : phoneArr) {
					phoneList.add(phone);
				}
			}
			// 增加通知测试人员
			if (StringUtils.isNotBlank(config.getTesterPhone())) {
				phoneList.add(config.getTesterPhone());
			}
			String message = new StringBuilder("线上应用:").append(config.getAppName()).append("的本次异常告警数为:")
					.append(errCount).append(",请关注并及时处理。").toString();
			PhoneAlarmObj alert = PhoneAlarmObj.builder().msg(message).build().addPhoneList(phoneList);
			String result = phoneWarning(alert);
			log.info("本次电话的告警信息：{}，告警电话：{}，响应内容：{}", message, phoneList, result);
		} catch (Exception e) {
			log.error("发起电话告警发生异常：" + e.getMessage(), e);
		}
	}
	
	@Override
	public int getOrder() {
		return 1;
	}

	/**
	 * 发起电话告警
	 * 
	 * @param phone   单个告警电话
	 * @param message 告警信息
	 * @return
	 */
	public static String phoneWarning(String phone, String message) {
		PhoneAlarmObj alert = PhoneAlarmObj.builder().msg(message).build().addPhone(phone);
		return phoneWarning(alert);
	}

	/**
	 * 发起电话告警
	 * 
	 * @param phoneList 多个告警电话列表
	 * @param message   告警信息
	 * @return
	 */
	public static String phoneWarning(List<String> phoneList, String message) {
		PhoneAlarmObj alert = PhoneAlarmObj.builder().msg(message).build().addPhoneList(phoneList);
		return phoneWarning(alert);
	}

	/**
	 * 发起电话告警
	 * 注：由于渠道接入可能不相同，如果需要实现电话告警，需要使用方自己实现
	 * 
	 * @param alert 告警的AlertMessage对象
	 * @return
	 */
	public static String phoneWarning(PhoneAlarmObj alert) {

		return null;
	}

}
