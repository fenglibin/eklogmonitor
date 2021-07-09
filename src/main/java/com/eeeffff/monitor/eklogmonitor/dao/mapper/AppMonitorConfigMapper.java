/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.eeeffff.monitor.eklogmonitor.common.mapper.BaseMapper;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
/**
* AppMonitorConfigMapper.
*
* @author  autoCode
* @version 1.0.0-SNAPSHOT
*/
@Mapper
@Repository
public interface AppMonitorConfigMapper extends BaseMapper<AppMonitorConfig> {

}
