package com.eeeffff.monitor.eklogmonitor.service.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eeeffff.monitor.eklogmonitor.common.response.ApiResponses;

/**
 * 应用异常监控报表相关的Controller
 * 
 * @author fenglibin
 *
 */
@RestController
@RequestMapping
@Validated
public class IndexController {

	/**
	 * 重新刷新缓存数据
	 * 
	 * @return
	 */
	@GetMapping("/")
	public ApiResponses<?> refresh() {
		return ApiResponses.success("OK");
	}

}
