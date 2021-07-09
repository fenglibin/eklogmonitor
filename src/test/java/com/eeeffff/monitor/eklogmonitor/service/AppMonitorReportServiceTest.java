package com.eeeffff.monitor.eklogmonitor.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eeeffff.monitor.eklogmonitor.AbstractSpringBootTest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorReportRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByApp;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorReportService;

public class AppMonitorReportServiceTest extends AbstractSpringBootTest {
	@Autowired 
	private IAppMonitorReportService appMonitorReportService;
	
	@Test
	public void testReportByApp() {
		AppMonitorReportRequest request = new AppMonitorReportRequest();
		request.setStartDate("2020-01-05");
		request.setEndDate("2020-01-07");
		List<AppMonitorReportByApp> list = appMonitorReportService.reportByApp(request);
		System.out.println(list);
	}
}
