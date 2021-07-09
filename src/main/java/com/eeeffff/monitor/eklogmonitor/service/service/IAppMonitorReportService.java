/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.service.service;

import java.util.List;

import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorReportRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByApp;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByDate;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByDept;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByOwner;

/**
* AppMonitorDeptMapper.
*
* @author  fenglibin
* @version 1.0.5
*/
public interface IAppMonitorReportService {
	/**
	 * 按日期维度统计
	 * 
	 * @param request
	 * @return
	 */
	List<AppMonitorReportByDate> reportByDate(AppMonitorReportRequest request);

	/**
	 * 按归属项目部维度统计
	 * 
	 * @param request
	 * @return
	 */
	List<AppMonitorReportByDept> reportByDept(AppMonitorReportRequest request);

	/**
	 * 按应用负责人维度统计
	 * 
	 * @param request
	 * @return
	 */
	List<AppMonitorReportByOwner> reportByOwner(AppMonitorReportRequest request);

	/**
	 * 按应用维度统计
	 * 
	 * @param request
	 * @return
	 */
	List<AppMonitorReportByApp> reportByApp(AppMonitorReportRequest request);
}
