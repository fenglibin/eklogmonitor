package com.eeeffff.monitor.eklogmonitor.service.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorDept;
import com.eeeffff.monitor.eklogmonitor.service.vo.CacheData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CacheService {
	@Autowired
	private IAppMonitorDeptService appMonitorDeptService;

	@Autowired
	private IAppMonitorConfigService appMonitorConfigService;

	/**
	 * 加载数据到缓存
	 */
	@PostConstruct
	public void init() {
		log.info("开始初使化项目归属项目部的基础数据...");
		List<AppMonitorDept> deptList = appMonitorDeptService.listAllDept();
		CacheData.getDeptList().addAll(deptList);
		deptList.forEach(d -> {
			CacheData.getDeptMap().put(d.getId(), d.getDeptName());
		});
		log.info("「完成初使化项目归属项目部的基础数据.");

		log.info("开始初使化项目项目监控错误配置的基础数据...");
		List<AppMonitorConfig> configList = appMonitorConfigService.list();
		CacheData.getConfigList().addAll(configList);
		configList.forEach(c -> {
			CacheData.getConfigIdMap().put(c.getId(), c);

			List<AppMonitorConfig> configlist = CacheData.getConfigOwnerMap().get(c.getAppOwner());
			if (configlist == null) {
				configlist = new ArrayList<AppMonitorConfig>();
				CacheData.getConfigOwnerMap().put(c.getAppOwner(), configlist);
			}
			configlist.add(c);
			
			List<String> configNamelist = CacheData.getConfigOwnerNameMap().get(c.getAppOwner());
			if (configNamelist == null) {
				configNamelist = new ArrayList<String>();
				CacheData.getConfigOwnerNameMap().put(c.getAppOwner(), configNamelist);
			}
			configNamelist.add(c.getAppName());

			configlist = CacheData.getConfigDeptMap().get(c.getDeptId());
			if (configlist == null) {
				configlist = new ArrayList<AppMonitorConfig>();
				CacheData.getConfigDeptMap().put(c.getDeptId(), configlist);
			}
			configlist.add(c);

			List<String> ownerList = CacheData.getDeptOwnerMap().get(c.getDeptId());
			if (ownerList == null) {
				ownerList = new ArrayList<String>();
				CacheData.getDeptOwnerMap().put(c.getDeptId(), ownerList);
			}
			ownerList.add(c.getAppOwner());
		});
		log.info("完成初使化项目项目监控错误配置的基础数据.");
	}

	/**
	 * 清除缓存
	 */
	public void clean() {
		CacheData.getConfigDeptMap().clear();
		CacheData.getConfigIdMap().clear();
		CacheData.getConfigList().clear();
		CacheData.getConfigOwnerMap().clear();
		CacheData.getDeptList().clear();
		CacheData.getDeptMap().clear();
		CacheData.getDeptOwnerMap().clear();
	}

	/**
	 * 重新初使化缓存
	 */
	public void reInit() {
		clean();
		init();
	}
}
