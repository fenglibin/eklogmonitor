/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.service.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataListRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataRemarkChangeRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataStatusChangeRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorDataListResponse;
import com.eeeffff.monitor.eklogmonitor.common.service.impl.ServiceImpl;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorData;
import com.eeeffff.monitor.eklogmonitor.dao.mapper.AppMonitorDataMapper;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorConfigService;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorDataService;
import com.eeeffff.monitor.eklogmonitor.service.vo.CacheData;

/**
 * AppMonitorDataMapper.
 *
 * @author autoCode
 * @version 1.0.0-SNAPSHOT
 */
@Service
public class AppMonitorDataServiceImpl extends ServiceImpl<AppMonitorDataMapper, AppMonitorData>
		implements IAppMonitorDataService {
	@Autowired
	private IAppMonitorConfigService appMonitorConfigService;

	@SuppressWarnings("unchecked")
	@Override
	public IPage<AppMonitorDataListResponse> appMonitorDataList(AppMonitorDataListRequest request) {
		LambdaQueryWrapper<AppMonitorData> queryWrapper = new QueryWrapper<AppMonitorData>().lambda();
		if (null != request.getConfigId()) {
			queryWrapper.eq(AppMonitorData::getConfigId, request.getConfigId());
		} else if (StringUtils.isNotEmpty(request.getAppOwner())) {
			List<Long> configIdList = new ArrayList<Long>();
			configIdList.add(99999999L);
			List<Long> configIdListByOwner = appMonitorConfigService.listAppIdByAppOwner(request.getAppOwner());
			if (CollectionUtils.isNotEmpty(configIdListByOwner)) {
				configIdList.addAll(configIdListByOwner);
			}
			queryWrapper.in(AppMonitorData::getConfigId, configIdList);
		} else if (request.getDeptId() != null) {
			List<Long> configIdList = new ArrayList<Long>();
			configIdList.add(99999999L);
			List<Long> configIdListByDept = appMonitorConfigService.listAppIdByDeptId(request.getDeptId());
			if (CollectionUtils.isNotEmpty(configIdListByDept)) {
				configIdList.addAll(configIdListByDept);
			}
			queryWrapper.in(AppMonitorData::getConfigId, configIdList);
		}
		if (null != request.getStatus()) {
			queryWrapper.eq(AppMonitorData::getStatus, request.getStatus());
		}
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if (StringUtils.isNotEmpty(request.getStartTime())) {
			queryWrapper.ge(AppMonitorData::getStartTime, LocalDateTime.parse(request.getStartTime()+" 00:00:01",df));
		}
		if (StringUtils.isNotEmpty(request.getEndTime())) {
			queryWrapper.lt(AppMonitorData::getEndTime, LocalDateTime.parse(request.getEndTime()+" 23:59:59",df));
		}
		queryWrapper.orderByDesc(AppMonitorData::getId);
		@SuppressWarnings("rawtypes")
		IPage<AppMonitorData> iPage = page(new Page(request.getPageNum(), request.getPageSize()), queryWrapper);
		IPage<AppMonitorDataListResponse> pageResult = new Page<>();
		BeanUtils.copyProperties(iPage, pageResult);
		List<AppMonitorDataListResponse> dataList = new ArrayList<>();
		iPage.getRecords().forEach(record -> {
			AppMonitorDataListResponse response = new AppMonitorDataListResponse();
			BeanUtils.copyProperties(record, response);
			AppMonitorConfig config = CacheData.getConfigIdMap().get(record.getConfigId());
			if(config == null) {
				config = appMonitorConfigService.getById(record.getConfigId());
				if(config != null) {
					CacheData.getConfigIdMap().put(record.getConfigId(), config);
				}
			}
			if(config == null) {
				return;
			}
			response.setAppName(config.getAppName());
			response.setAppOwner(config.getAppOwner());
			response.setDeptId(config.getDeptId());
			response.setDeptName(CacheData.getDeptMap().get(config.getDeptId()));
			dataList.add(response);
		});
		pageResult.setRecords(dataList);
		return pageResult;
	}

	@Override
	public Boolean editAppDataStatus(AppMonitorDataStatusChangeRequest request) {
		// 填充KibanaIndex
		AppMonitorData entity = new AppMonitorData();
		BeanUtils.copyProperties(request, entity);
		return updateById(entity);
	}

	@Override
	public AppMonitorData getDetail(Long id) {
		return getById(id);
	}

	@Override
	public Boolean editAppDataRemark(AppMonitorDataRemarkChangeRequest request) {
		// 填充KibanaIndex
		AppMonitorData entity = new AppMonitorData();
		BeanUtils.copyProperties(request, entity);
		return updateById(entity);
	}
}
