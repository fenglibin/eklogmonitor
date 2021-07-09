/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.service.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorConfigListRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorConfigRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigListResponse;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigOwnerResponse;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorConfigResponse;
import com.eeeffff.monitor.eklogmonitor.common.service.IService;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;

/**
* AppMonitorConfigMapper.
*
* @author  autoCode
* @version 1.0.0-SNAPSHOT
*/
public interface IAppMonitorConfigService extends IService<AppMonitorConfig> {

    /**
     * 获取EsIndex和KibanaId的映射关系
     * @return
     */
    ConcurrentHashMap<String, String> getEsIndexAndKibanaIdMap();

    /**
     * 列表展示应用监控配置
     * @param request
     * @return
     */
    IPage<AppMonitorConfigListResponse> listAppMonitorConfig(AppMonitorConfigListRequest request);

    /**
     * 编辑应用监控配置
     * @param request
     * @return
     */
    boolean editAppMonitorConfig(AppMonitorConfigRequest request);

    /**
     * 根据Id查询详情
     * @param id
     * @return
     */
    AppMonitorConfigResponse getAppMonitorConfigById(Long id);


    /**
     * 禁用应用监控配置
     * @param id
     * @return
     */
    boolean disableAppMonitorConfig(Long id);
    
    /**
     * 列表展示应用监控负责人
     * @param deptId
     * @return
     */
    List<AppMonitorConfigOwnerResponse> listAppMonitorConfigOwner(Long deptId);
    
    /**
     * 根据应用负责人，查询其负责的应用配置的ID列表
     * @param appOwner
     * @return
     */
    List<Long> listAppIdByAppOwner(String appOwner);
    
    /**
     * 根据应用归属项目部的ID，查询其负责的应用配置的ID列表
     * @param deptId
     * @return
     */
    List<Long> listAppIdByDeptId(Long deptId);
}
