/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eeeffff.monitor.eklogmonitor.common.service.impl.ServiceImpl;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorDept;
import com.eeeffff.monitor.eklogmonitor.dao.mapper.AppMonitorDeptMapper;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorDeptService;
/**
* AppMonitorDeptMapper.
*
* @author  autoCode
* @version 1.0.5
*/
@Service
public class AppMonitorDeptServiceImpl extends ServiceImpl<AppMonitorDeptMapper, AppMonitorDept> implements IAppMonitorDeptService {

	@Override
	public List<AppMonitorDept> listAllDept() {
		return list();
	}


}
