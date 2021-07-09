package com.eeeffff.monitor.eklogmonitor.config;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.eeeffff.monitor.eklogmonitor.AbstractSpringBootTest;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.service.config.AppMonitorProperties;

public class AppMonitorPropertiesTest extends AbstractSpringBootTest{

	@Autowired
	private AppMonitorProperties appMonitorProperties;
	@Test
	public void test1() {
		// TODO Auto-generated method stub
		Map<Long, String> map = new HashMap<Long, String>();
		map.put(1L, "1111111,1111111");
		map.put(2L, "2222,2222");
		String str = JSONObject.toJSONString(map);
		System.out.println(str);
		Map<Long,String> result = JSONObject.parseObject(str, new TypeReference<Map<Long,String>>(){});
		System.out.println(result);
		System.out.println(result.get(1L));
	}
	@Test
	public void test2() {
		AppMonitorConfig config = new AppMonitorConfig();
		config.setDeptId(1L);
		System.out.println("appMonitorProperties:"+appMonitorProperties.getPhoneAlertExtraUsers());
		System.out.println("appMonitorProperties:"+appMonitorProperties.getPhoneAlertExtraUsers().get(config.getDeptId()));
	}

}
