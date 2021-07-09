/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataListRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataRemarkChangeRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataStatusChangeRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorDataListResponse;
import com.eeeffff.monitor.eklogmonitor.common.service.IService;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorData;

/**
 * AppMonitorDataMapper.
 *
 * @author autoCode
 * @version 1.0.0-SNAPSHOT
 */
public interface IAppMonitorDataService extends IService<AppMonitorData> {

	/**
	 * 列表查询
	 * 
	 * @param request
	 * @return
	 */
	IPage<AppMonitorDataListResponse> appMonitorDataList(AppMonitorDataListRequest request);

	/**
	 * 更新当前告警的状态
	 * 
	 * @param request
	 * @return
	 */
	Boolean editAppDataStatus(AppMonitorDataStatusChangeRequest request);
	
	/**
	 * 获取单条告警任务的详情
	 * @param id
	 * @return
	 */
	AppMonitorData getDetail(Long id);
	
	/**
	 * 更新告警任务的说明
	 * @param request
	 * @return
	 */
	Boolean editAppDataRemark(AppMonitorDataRemarkChangeRequest request);
}
