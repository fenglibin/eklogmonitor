package com.eeeffff.monitor.eklogmonitor.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eeeffff.monitor.eklogmonitor.common.response.ApiResponses;
import com.eeeffff.monitor.eklogmonitor.service.service.CacheService;

/**
 * 应用异常监控报表相关的Controller
 * 
 * @author fenglibin
 *
 */
@RestController
@RequestMapping(value = "/app/monitor/cache")
@Validated
public class AppMonitorCacheController {
	@Autowired
	private CacheService cacheService;

	/**
	 * 重新刷新缓存数据
	 * 
	 * @return
	 */
	@PostMapping("/refresh")
	public ApiResponses<?> refresh() {
		cacheService.reInit();
		return ApiResponses.success();
	}

}
