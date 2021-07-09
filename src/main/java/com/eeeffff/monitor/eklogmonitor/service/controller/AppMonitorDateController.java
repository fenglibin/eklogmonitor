package com.eeeffff.monitor.eklogmonitor.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataListRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataRemarkChangeRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorDataStatusChangeRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorDataListResponse;
import com.eeeffff.monitor.eklogmonitor.common.response.ApiResponses;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorData;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorDataService;

/**
 * 应用异常监控数据Controller
 * @author fenglibin
 *
 */
@RestController
@RequestMapping(value = "/app/monitor/data")
@Validated
public class AppMonitorDateController {

    @Autowired
    private IAppMonitorDataService appMonitorDataService;

    /**
     * 数据列表查询
     * @param request
     * @return
     */
    @PostMapping("/list")
    public ApiResponses<IPage<AppMonitorDataListResponse>> appMonitorDataList(@RequestBody AppMonitorDataListRequest request){
        return ApiResponses.success(appMonitorDataService.appMonitorDataList(request));
    }
    
    /**
     * 更新
     * 
     * @param request
     * @return
     */
    @PostMapping("/updateStatus")
    public ApiResponses<Boolean> appMonitorDataStatusUpdate(@RequestBody AppMonitorDataStatusChangeRequest request) {
        return ApiResponses.success(appMonitorDataService.editAppDataStatus(request));
    }
    
    /**
     * 获取单条任务的详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public ApiResponses<AppMonitorData> detail(@RequestParam Long id) {
    	return ApiResponses.success(appMonitorDataService.getDetail(id));
    }
    
    /**
     * 更新
     * 
     * @param request
     * @return
     */
    @PostMapping("/updateRemark")
    public ApiResponses<Boolean> appMonitorDataRemarkUpdate(@RequestBody AppMonitorDataRemarkChangeRequest request) {
        return ApiResponses.success(appMonitorDataService.editAppDataRemark(request));
    }
}