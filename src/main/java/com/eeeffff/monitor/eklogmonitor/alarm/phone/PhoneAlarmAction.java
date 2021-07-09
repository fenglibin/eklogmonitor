package com.eeeffff.monitor.eklogmonitor.alarm.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeeffff.monitor.eklogmonitor.alarm.AlarmAction;
import com.eeeffff.monitor.eklogmonitor.alarm.util.JacksonUtil;
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
	private static final String alertPhoneUrl = "http://172.16.100.100:16898/alert";

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
			String result = PhoneAlarmAction.phoneWarning(alert);
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
	 * 
	 * @param alert 告警的AlertMessage对象
	 * @return
	 */
	public static String phoneWarning(PhoneAlarmObj alert) {
		String param = JacksonUtil.writeValueAsString(alert);
		HttpURLConnection connection = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(alertPhoneUrl);
			// 通过远程url连接对象打开连接
			connection = (HttpURLConnection) url.openConnection();
			// 设置连接请求方式
			connection.setRequestMethod("POST");
			// 设置连接主机服务器超时时间：15000毫秒
			connection.setConnectTimeout(15000);
			// 设置读取主机服务器返回数据超时时间：60000毫秒
			connection.setReadTimeout(60000);

			// 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
			connection.setDoOutput(true);
			// 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
			connection.setDoInput(true);
			// 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
			connection.setRequestProperty("Content-Type", "application/json");
			// 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
			connection.setRequestProperty("Authorization", "Token bGFpZGlhbnRlY2g=");
			// 通过连接对象获取一个输出流
			os = connection.getOutputStream();
			// 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
			os.write(param.getBytes());
			// 通过连接对象获取一个输入流，向远程读取
			if (connection.getResponseCode() == 200) {

				is = connection.getInputStream();
				// 对输入流对象进行包装:charset根据工作项目组的要求来设置
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				StringBuffer sbf = new StringBuffer();
				String temp = null;
				// 循环遍历一行一行读取数据
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			log.error("MalformedURLException:" + e.getMessage(), e);
		} catch (IOException e) {
			log.error("IOException:" + e.getMessage(), e);
		} catch (Exception e) {
			log.error("Exception:" + e.getMessage(), e);
		} finally {
			// 关闭资源
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					log.error("IOException:" + e.getMessage(), e);
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					log.error("IOException:" + e.getMessage(), e);
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("IOException:" + e.getMessage(), e);
				}
			}
			// 断开与远程地址url的连接
			connection.disconnect();
		}
		return result;
	}

}
