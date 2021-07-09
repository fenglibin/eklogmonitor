package com.eeeffff.monitor.eklogmonitor.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eeeffff.monitor.eklogmonitor.common.response.ApiResponses;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorDept;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorDeptService;

/**
 * 应用异常监控归属项目部Controller
 * 
 * @author fenglb
 *
 */
@RestController
@RequestMapping(value = "/app/monitor/dept")
@Validated
public class AppMonitorDeptController {

	@Autowired
	private IAppMonitorDeptService appMonitorDeptService;

	/**
	 * 应用异常监控归属项目部列表
	 * 
	 * @return
	 */
	@PostMapping("/list")
	public ApiResponses<List<AppMonitorDept>> listAllDept() {
		return ApiResponses.success(appMonitorDeptService.listAllDept());
	}
}