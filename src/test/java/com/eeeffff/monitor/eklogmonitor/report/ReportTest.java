package com.eeeffff.monitor.eklogmonitor.report;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eeeffff.monitor.eklogmonitor.AbstractSpringBootTest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorReportRequest;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorReport;
import com.eeeffff.monitor.eklogmonitor.dao.mapper.AppMonitorDataExMapper;

public class ReportTest extends AbstractSpringBootTest{
	@Autowired
	private AppMonitorDataExMapper appMonitorDataExMapper;
	
	@Test
	public void testReport1() {
		AppMonitorReportRequest request = new AppMonitorReportRequest();
		request.setStatus(0);
		List<AppMonitorReport> list = appMonitorDataExMapper.reportByDate(request);
		System.out.println(list);
		request.setStatus(1);
		list = appMonitorDataExMapper.reportByDate(request);
		System.out.println(list);
		request.setStatus(null);
		list = appMonitorDataExMapper.reportByDate(request);
		System.out.println(list);
	}
}
