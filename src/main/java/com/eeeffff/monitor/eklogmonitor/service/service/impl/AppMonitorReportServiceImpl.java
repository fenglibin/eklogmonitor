package com.eeeffff.monitor.eklogmonitor.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorReportRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByApp;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByDate;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByDept;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByOwner;
import com.eeeffff.monitor.eklogmonitor.common.service.impl.ServiceImpl;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorReport;
import com.eeeffff.monitor.eklogmonitor.dao.mapper.AppMonitorDataExMapper;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorReportService;

/**
 * 
 * @author fenglibin
 *
 */
@Service
public class AppMonitorReportServiceImpl extends ServiceImpl<AppMonitorDataExMapper, AppMonitorReport>
		implements IAppMonitorReportService {
	@Autowired
	private AppMonitorDataExMapper appMonitorDataExMapper;

	@Override
	public List<AppMonitorReportByDate> reportByDate(AppMonitorReportRequest request) {
		List<AppMonitorReportByDate> result = new ArrayList<AppMonitorReportByDate>();
		List<AppMonitorReport> list = appMonitorDataExMapper.reportByDate(request);
		if (CollectionUtils.isNotEmpty(list)) {
			list.forEach(a -> {
				AppMonitorReportByDate instance = new AppMonitorReportByDate();
				BeanUtils.copyProperties(a, instance);
				result.add(instance);
			});
		}
		return result;
	}

	@Override
	public List<AppMonitorReportByDept> reportByDept(AppMonitorReportRequest request) {
		List<AppMonitorReportByDept> result = new ArrayList<AppMonitorReportByDept>();
		List<AppMonitorReport> list = appMonitorDataExMapper.reportByDept(request);
		if (CollectionUtils.isNotEmpty(list)) {
			list.forEach(a -> {
				AppMonitorReportByDept instance = new AppMonitorReportByDept();
				BeanUtils.copyProperties(a, instance);
				result.add(instance);
			});
		}
		return result;
	}

	@Override
	public List<AppMonitorReportByOwner> reportByOwner(AppMonitorReportRequest request) {
		List<AppMonitorReportByOwner> result = new ArrayList<AppMonitorReportByOwner>();
		List<AppMonitorReport> list = appMonitorDataExMapper.reportByOwner(request);
		if (CollectionUtils.isNotEmpty(list)) {
			list.forEach(a -> {
				AppMonitorReportByOwner instance = new AppMonitorReportByOwner();
				BeanUtils.copyProperties(a, instance);
				result.add(instance);
			});
		}
		return result;
	}

	@Override
	public List<AppMonitorReportByApp> reportByApp(AppMonitorReportRequest request) {
		List<AppMonitorReportByApp> result = new ArrayList<AppMonitorReportByApp>();
		List<AppMonitorReport> list = appMonitorDataExMapper.reportByApp(request);
		if (CollectionUtils.isNotEmpty(list)) {
			list.forEach(a -> {
				AppMonitorReportByApp instance = new AppMonitorReportByApp();
				BeanUtils.copyProperties(a, instance);
				result.add(instance);
			});
		}
		return result;
	}

}
