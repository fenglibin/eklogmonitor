/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.service.service;

import java.util.List;

import com.eeeffff.monitor.eklogmonitor.common.service.IService;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorDept;
/**
* AppMonitorDeptMapper.
*
* @author  autoCode
* @version 1.0.5
*/
public interface IAppMonitorDeptService extends IService<AppMonitorDept> {
	/**
	 * 查询所有的数据
	 * @return
	 */
	List<AppMonitorDept> listAllDept();
}
