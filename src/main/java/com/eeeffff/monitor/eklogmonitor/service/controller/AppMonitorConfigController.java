package com.eeeffff.monitor.eklogmonitor.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorConfigListRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorConfigRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigListResponse;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigOwnerResponse;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigResponse;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.EsIndexKibanaIdMapResponse;
import com.eeeffff.monitor.eklogmonitor.common.response.ApiResponses;
import com.eeeffff.monitor.eklogmonitor.service.service.CacheService;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorConfigService;

/**
 * 应用异常监控配置Controller
 * 
 * @author fenglibin
 *
 */
@RestController
@RequestMapping(value = "/app/monitor/config")
@Validated
public class AppMonitorConfigController {

    @Autowired
    private IAppMonitorConfigService appMonitorConfigService;
    
    @Autowired
	private CacheService cacheService;

    /**
     * 应用异常监控配置列表
     * 
     * @param request
     * @return
     */
    @PostMapping("/list")
    public ApiResponses<IPage<AppMonitorConfigListResponse>>
        appMonitorConfigList(@RequestBody AppMonitorConfigListRequest request) {
        return ApiResponses.success(appMonitorConfigService.listAppMonitorConfig(request));
    }

    /**
     * 新增配置
     * 
     * @param request
     * @return
     */
    @PostMapping("/save")
    public ApiResponses<Boolean> appMonitorConfigAdd(@RequestBody AppMonitorConfigRequest request) {
    	boolean result = appMonitorConfigService.editAppMonitorConfig(request);
    	cacheService.reInit();
        return ApiResponses.success(result);
    }

    /**
     * 修改配置
     * 
     * @param request
     * @return
     */
    @PostMapping("/update")
    public ApiResponses<Boolean> appMonitorConfigUpdate(@RequestBody AppMonitorConfigRequest request) {
    	boolean result = appMonitorConfigService.editAppMonitorConfig(request);
    	cacheService.reInit();
        return ApiResponses.success(result);
    }

    /**
     * 获取配置详情
     * 
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public ApiResponses<AppMonitorConfigResponse> appMonitorConfigDetail(Long id) {
        return ApiResponses.success(appMonitorConfigService.getAppMonitorConfigById(id));
    }

    /**
     * 禁用配置
     * 
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public ApiResponses<Boolean> appMocnitorConfigDelete(Long id) {
    	boolean result = appMonitorConfigService.disableAppMonitorConfig(id);
    	cacheService.reInit();
        return ApiResponses.success(result);
    }

    /**
     * 获取EsIndex和KibanaId的映射关系
     * 
     * @return
     */
    @GetMapping("/fetch/es/kibana")
    public ApiResponses<List<EsIndexKibanaIdMapResponse>> fetchEsIndexAndKibanaIdMap() {
        List<EsIndexKibanaIdMapResponse> list = new ArrayList<>();
        ConcurrentHashMap<String, String> map = appMonitorConfigService.getEsIndexAndKibanaIdMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            EsIndexKibanaIdMapResponse response = new EsIndexKibanaIdMapResponse();
            response.setEsIndex(entry.getKey());
            response.setKibanaId(entry.getValue());
            list.add(response);
        }
        return ApiResponses.success(list);
    }
    
    /**
     * 列表展示应用监控负责人
     * @return
     */
    @PostMapping("/configOwner")
    public ApiResponses<List<AppMonitorConfigOwnerResponse>> appMonitorConfigOwner(Long deptId) {
        return ApiResponses.success(appMonitorConfigService.listAppMonitorConfigOwner(deptId));
    }
    
    /**
     * 根据应用负责人的名称，查询该应用负责人对应负责的应用配置的ID列表
     * @return
     */
    @PostMapping("/configOwnerIds")
    public ApiResponses<List<Long>> appMonitorConfigOwner(String appOwner) {
        return ApiResponses.success(appMonitorConfigService.listAppIdByAppOwner(appOwner));
    }
}