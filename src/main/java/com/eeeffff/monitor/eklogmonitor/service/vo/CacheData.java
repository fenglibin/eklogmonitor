package com.eeeffff.monitor.eklogmonitor.service.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorDept;

public class CacheData {
	// 保存所有的应用归属项目部的信息
	private static List<AppMonitorDept> deptList = new ArrayList<AppMonitorDept>();
	// 保存应用归属项目部ID与名称的映射Map
	private static Map<Long, String> deptMap = new HashMap<Long, String>();
	// 保存所有的应用问题监控配置
	private static List<AppMonitorConfig> configList = new ArrayList<AppMonitorConfig>();

	// 保存应用错误监控配置ID与应用错误监控配置的映射Map
	private static Map<Long, AppMonitorConfig> configIdMap = new HashMap<Long, AppMonitorConfig>();

	// 保存应用错误监控配置的归属人与应用错误监控配置的映射Map
	private static Map<String, List<AppMonitorConfig>> configOwnerMap = new HashMap<String, List<AppMonitorConfig>>();
	// 保存应用错误监控配置的归属人与应用错误监控配置名称的映射Map
	private static Map<String, List<String>> configOwnerNameMap = new HashMap<String, List<String>>();

	// 保存应用归属项目部与应用错误监控配置的映射Map
	private static Map<Long, List<AppMonitorConfig>> configDeptMap = new HashMap<Long, List<AppMonitorConfig>>();

	// 保存应用归属项目部与应用负责人的映射Map
	private static Map<Long, List<String>> deptOwnerMap = new HashMap<Long, List<String>>();

	public static List<AppMonitorDept> getDeptList() {
		return deptList;
	}

	public static Map<Long, String> getDeptMap() {
		return deptMap;
	}

	public static List<AppMonitorConfig> getConfigList() {
		return configList;
	}

	public static Map<Long, AppMonitorConfig> getConfigIdMap() {
		return configIdMap;
	}

	public static Map<String, List<AppMonitorConfig>> getConfigOwnerMap() {
		return configOwnerMap;
	}

	public static Map<String, List<String>> getConfigOwnerNameMap() {
		return configOwnerNameMap;
	}

	public static Map<Long, List<AppMonitorConfig>> getConfigDeptMap() {
		return configDeptMap;
	}

	public static Map<Long, List<String>> getDeptOwnerMap() {
		return deptOwnerMap;
	}

}
