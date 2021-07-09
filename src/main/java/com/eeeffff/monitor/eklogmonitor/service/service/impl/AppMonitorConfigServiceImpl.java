/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.service.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorConfigListRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorConfigRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigListResponse;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigOwnerResponse;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigResponse;
import com.eeeffff.monitor.eklogmonitor.common.service.impl.ServiceImpl;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.mapper.AppMonitorConfigMapper;
import com.eeeffff.monitor.eklogmonitor.service.config.AppMonitorProperties;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorConfigService;
import com.eeeffff.monitor.eklogmonitor.service.vo.CacheData;

import lombok.extern.slf4j.Slf4j;

/**
 * AppMonitorConfigMapper.
 *
 * @author autoCode
 * @version 1.0.0-SNAPSHOT
 */
@Service
@Slf4j
public class AppMonitorConfigServiceImpl extends ServiceImpl<AppMonitorConfigMapper, AppMonitorConfig>
		implements IAppMonitorConfigService, InitializingBean {

	@Override
	public ConcurrentHashMap<String, String> getEsIndexAndKibanaIdMap() {
		return esIndexAndKibanaIdMap;
	}

	/**
	 * 
	 * 存放esIndex -> kibanaId的对应关系
	 */
	private ConcurrentHashMap<String, String> esIndexAndKibanaIdMap = new ConcurrentHashMap<>();

	@Autowired
	@Qualifier("allowAllHttpsRestTemplate")
	private RestTemplate restTemplate;

	@Autowired
	private AppMonitorProperties appMonitorProperties;

	@SuppressWarnings({ "unchecked" })
	@Override
	public IPage<AppMonitorConfigListResponse> listAppMonitorConfig(AppMonitorConfigListRequest request) {
		LambdaQueryWrapper<AppMonitorConfig> queryWrapper = new QueryWrapper<AppMonitorConfig>().lambda();
		if (request.getDeptId() != null && request.getDeptId() > 0) {
			queryWrapper.eq(AppMonitorConfig::getDeptId, request.getDeptId());
		}
		if (StringUtils.isNotEmpty(request.getAppOwner())) {
			queryWrapper.eq(AppMonitorConfig::getAppOwner, request.getAppOwner());
		}
		if (request.getConfigId() != null && request.getConfigId() > 0) {
			queryWrapper.eq(AppMonitorConfig::getId, request.getConfigId());
		}
		if (StringUtils.isNotBlank(request.getAppName())) {
			queryWrapper.likeLeft(AppMonitorConfig::getAppName, request.getAppName());
		}
		if (StringUtils.isNotBlank(request.getAlarmMobile())) {
			queryWrapper.like(AppMonitorConfig::getDdRobotMobile, request.getAlarmMobile());
		}
		if (StringUtils.isNotBlank(request.getEsIndex())) {
			queryWrapper.eq(AppMonitorConfig::getEsIndex, request.getEsIndex());
		}
		if (StringUtils.isNotBlank(request.getTesterName())) {
			queryWrapper.eq(AppMonitorConfig::getTesterName, request.getTesterName());
		}
		if (StringUtils.isNotBlank(request.getTesterPhone())) {
			queryWrapper.eq(AppMonitorConfig::getTesterPhone, request.getTesterPhone());
		}
		queryWrapper.eq(AppMonitorConfig::getIsDel, 0);
		queryWrapper.orderByDesc(AppMonitorConfig::getId);
		@SuppressWarnings("rawtypes")
		IPage iPage = page(new Page<>(request.getPageNum(), request.getPageSize()), queryWrapper);

		IPage<AppMonitorConfigListResponse> pageResult = new Page<>();
		BeanUtils.copyProperties(iPage, pageResult);
		List<AppMonitorConfigListResponse> configListResponseList = new ArrayList<>();
		iPage.getRecords().forEach(record -> {
			AppMonitorConfigListResponse configListResponse = new AppMonitorConfigListResponse();
			BeanUtils.copyProperties(record, configListResponse);
			// 获取归属事业部
			configListResponse.setDeptName(CacheData.getDeptMap().get(configListResponse.getDeptId()));
			configListResponseList.add(configListResponse);
		});
		pageResult.setRecords(configListResponseList);
		return pageResult;
	}

	@Override
	public boolean editAppMonitorConfig(AppMonitorConfigRequest request) {
		// 填充KibanaIndex
		AppMonitorConfig entity = new AppMonitorConfig();
		if (StringUtils.isNotBlank(request.getEsIndex())) {
			entity.setKibanaIndex(esIndexAndKibanaIdMap.get(request.getEsIndex()));
		}
		BeanUtils.copyProperties(request, entity);

		if (request.getId() == null) {
			entity.setCreateUserId(request.getOptUserId());
			return save(entity);
		} else {
			entity.setUpdateUserId(request.getOptUserId());
			entity.setUpdateTime(null);
			return updateById(entity);
		}
	}

	@Override
	public AppMonitorConfigResponse getAppMonitorConfigById(Long id) {
		AppMonitorConfig entity = getById(id);
		AppMonitorConfigResponse response = new AppMonitorConfigResponse();
		BeanUtils.copyProperties(entity, response);
		response.setDeptId(response.getDeptId());
		response.setDeptName(CacheData.getDeptMap().get(response.getDeptId()));
		return response;
	}

	@Override
	public boolean disableAppMonitorConfig(Long id) {
		AppMonitorConfig entity = new AppMonitorConfig();
		entity.setId(id);
		entity.setIsDel(1);
		entity.setUpdateTime(null);
		return updateById(entity);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initEsIndexKibanaIdRelationshop();
	}

	/**
	 * 
	 * @throws Exception
	 */
	private void initEsIndexKibanaIdRelationshop() {
		try {
			JSONObject result = restTemplate.getForObject(appMonitorProperties.getKibanaQueryIndexUrl(),
					JSONObject.class);
			if (result.containsKey("saved_objects")) {
				JSONArray savedObjects = result.getJSONArray("saved_objects");
				for (int i = 0; i < savedObjects.size(); i++) {
					JSONObject savedObj = savedObjects.getJSONObject(i);
					String kibanaId = savedObj.getString("id");
					String esIndex = savedObj.containsKey("attributes")
							? savedObj.getJSONObject("attributes").getString("title")
							: null;
					if (StringUtils.isBlank(kibanaId) || StringUtils.isBlank(esIndex)) {
						continue;
					}
					log.info("初始化EsIndex和KibanaId对应关系 esIndex:{} KibanaId:{}", esIndex, kibanaId);
					esIndexAndKibanaIdMap.put(esIndex, kibanaId);
				}
			}
		} catch (Exception e) {
			log.error("初使化ES Index与KibanaId的对应关系发生异常：" + e.getMessage(), e);
		}
	}

	@Override
	public List<AppMonitorConfigOwnerResponse> listAppMonitorConfigOwner(Long deptId) {
		LambdaQueryWrapper<AppMonitorConfig> queryWrapper = new QueryWrapper<AppMonitorConfig>()
				.select("distinct appOwner").lambda();
		if (deptId != null && deptId > 0) {
			queryWrapper.eq(AppMonitorConfig::getDeptId, deptId);
		}
		queryWrapper.eq(AppMonitorConfig::getIsDel, 0);
		IPage<?> iPage = page(new Page<>(1, 500), queryWrapper);

		List<AppMonitorConfigOwnerResponse> configOwnerResponseList = new ArrayList<>();
		iPage.getRecords().forEach(record -> {
			AppMonitorConfigOwnerResponse configOwnerResponse = new AppMonitorConfigOwnerResponse();
			BeanUtils.copyProperties(record, configOwnerResponse);
			configOwnerResponseList.add(configOwnerResponse);
		});
		return configOwnerResponseList;
	}

	@Override
	public List<Long> listAppIdByAppOwner(String appOwner) {
		List<Long> result = new ArrayList<Long>();
		if (StringUtils.isEmpty(appOwner)) {
			return result;
		}
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("appOwner", appOwner);
		Collection<AppMonitorConfig> list = listByMap(columnMap);
		if (CollectionUtils.isEmpty(list)) {
			return result;
		}
		list.forEach(c -> {
			result.add(c.getId());
		});
		return result;
	}

	@Override
	public List<Long> listAppIdByDeptId(Long deptId) {
		List<Long> result = new ArrayList<Long>();
		if (deptId == null || deptId <= 0) {
			return result;
		}
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("deptId", deptId);
		Collection<AppMonitorConfig> list = listByMap(columnMap);
		if (CollectionUtils.isEmpty(list)) {
			return result;
		}
		list.forEach(c -> {
			result.add(c.getId());
		});
		return result;
	}
}
