/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.eeeffff.monitor.eklogmonitor.common.mapper.BaseMapper;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorReport;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorReportRequest;

/**
 * AppMonitorReportMapper.
 *
 * @author fenglibin
 * @version 1.0.5
 */
@Mapper
@Repository
public interface AppMonitorDataExMapper extends BaseMapper<AppMonitorReport> {
	/**
	 * 按日期维度统计
	 * 
	 * @param request
	 * @return
	 */
	List<AppMonitorReport> reportByDate(AppMonitorReportRequest request);

	/**
	 * 按归属项目部维度统计
	 * 
	 * @param request
	 * @return
	 */
	List<AppMonitorReport> reportByDept(AppMonitorReportRequest request);

	/**
	 * 按应用负责人维度统计
	 * 
	 * @param request
	 * @return
	 */
	List<AppMonitorReport> reportByOwner(AppMonitorReportRequest request);

	/**
	 * 按应用维度统计
	 * 
	 * @param request
	 * @return
	 */
	List<AppMonitorReport> reportByApp(AppMonitorReportRequest request);
}
