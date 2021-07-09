package com.eeeffff.monitor.eklogmonitor.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eeeffff.monitor.eklogmonitor.common.dto.req.AppMonitorReportRequest;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByApp;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByDate;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByDept;
import com.eeeffff.monitor.eklogmonitor.common.dto.rsp.AppMonitorReportByOwner;
import com.eeeffff.monitor.eklogmonitor.common.response.ApiResponses;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.service.service.IAppMonitorReportService;
import com.eeeffff.monitor.eklogmonitor.service.vo.CacheData;

/**
 * 应用异常监控报表相关的Controller
 * 
 * @author fenglibin
 *
 */
@RestController
@RequestMapping(value = "/app/monitor/report")
@Validated
public class AppMonitorReportController {
	@Autowired
	private IAppMonitorReportService appMonitorReportService;

	/**
	 * 按日期维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByDate")
	public ApiResponses<List<AppMonitorReportByDate>> reportByDate(@RequestBody AppMonitorReportRequest request) {
		List<AppMonitorReportByDate> result = new ArrayList<AppMonitorReportByDate>();
		List<String> dateList = request.getDateList();
		dateList.forEach(date -> {
			request.setCurrentDate(date);
			List<AppMonitorReportByDate> list = appMonitorReportService.reportByDate(request);
			if (CollectionUtils.isNotEmpty(list)) {
				result.addAll(list);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按归属项目部维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByDept")
	public ApiResponses<Map<String, List<AppMonitorReportByDept>>> reportByDept(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// Key为归属项目部的名称
		Map<String, List<AppMonitorReportByDept>> result = new TreeMap<String, List<AppMonitorReportByDept>>();
		getDeptIdList(request).forEach(deptId -> {
			List<AppMonitorReportByDept> appList = new ArrayList<AppMonitorReportByDept>();
			req.setDeptId(deptId);
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {
				req.setCurrentDate(date);
				List<AppMonitorReportByDept> list = appMonitorReportService.reportByDept(req);
				if (CollectionUtils.isNotEmpty(list)) {
					appList.addAll(list);
				}
			});
			if (CollectionUtils.isNotEmpty(appList)) {
				result.put(CacheData.getDeptMap().get(deptId), appList);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按应用负责人维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByOwner")
	public ApiResponses<Map<String, List<AppMonitorReportByOwner>>> reportByOwner(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// Key为归属项目部的名称
		Map<String, List<AppMonitorReportByOwner>> result = new TreeMap<String, List<AppMonitorReportByOwner>>();
		getDeptIdList(request).forEach(deptId -> {
			List<AppMonitorReportByOwner> appList = new ArrayList<AppMonitorReportByOwner>();
			req.setDeptId(deptId);
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {
				req.setCurrentDate(date);
				List<AppMonitorReportByOwner> list = appMonitorReportService.reportByOwner(req);
				if (CollectionUtils.isNotEmpty(list)) {
					appList.addAll(list);
				}
			});
			if (CollectionUtils.isNotEmpty(appList)) {
				result.put(CacheData.getDeptMap().get(deptId), appList);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按应用维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByApp")
	public ApiResponses<Map<String, List<AppMonitorReportByApp>>> reportByApp(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// Key为归属项目部的名称
		Map<String, List<AppMonitorReportByApp>> result = new TreeMap<String, List<AppMonitorReportByApp>>();
		getDeptIdList(request).forEach(deptId -> {
			List<AppMonitorReportByApp> appList = new ArrayList<AppMonitorReportByApp>();
			req.setDeptId(deptId);
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {
				req.setCurrentDate(date);
				List<AppMonitorReportByApp> list = appMonitorReportService.reportByApp(req);
				if (CollectionUtils.isNotEmpty(list)) {
					appList.addAll(list);
				}
			});
			if (CollectionUtils.isNotEmpty(appList)) {
				result.put(CacheData.getDeptMap().get(deptId), appList);
			}
		});
		return ApiResponses.success(result);
	}
	
	/**
	 * 按日期维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByDate0")
	public ApiResponses<List<AppMonitorReportByDate>> reportByDate0(@RequestBody AppMonitorReportRequest request) {
		List<AppMonitorReportByDate> result = new ArrayList<AppMonitorReportByDate>();
		List<String> dateList = request.getDateList();
		dateList.forEach(date -> {
			request.setCurrentDate(date);
			List<AppMonitorReportByDate> list = appMonitorReportService.reportByDate(request);
			if (CollectionUtils.isNotEmpty(list)) {
				result.addAll(list);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按归属项目部维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByDept0")
	public ApiResponses<Map<String, List<AppMonitorReportByDept>>> reportByDept0(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// Key为归属项目部的名称
		Map<String, List<AppMonitorReportByDept>> result = new TreeMap<String, List<AppMonitorReportByDept>>();
		getDeptIdList(request).forEach(deptId -> {
			List<AppMonitorReportByDept> appList = new ArrayList<AppMonitorReportByDept>();
			req.setDeptId(deptId);
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {
				req.setCurrentDate(date);
				List<AppMonitorReportByDept> list = appMonitorReportService.reportByDept(req);
				if (CollectionUtils.isNotEmpty(list)) {
					appList.addAll(list);
				}
			});
			if (CollectionUtils.isNotEmpty(appList)) {
				result.put(CacheData.getDeptMap().get(deptId), appList);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按应用负责人维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByOwner0")
	public ApiResponses<Map<String, List<AppMonitorReportByOwner>>> reportByOwner0(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// Key为归属项目部的名称
		Map<String, List<AppMonitorReportByOwner>> result = new TreeMap<String, List<AppMonitorReportByOwner>>();
		getDeptIdList(request).forEach(deptId -> {
			List<AppMonitorReportByOwner> appList = new ArrayList<AppMonitorReportByOwner>();
			req.setDeptId(deptId);
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {
				req.setCurrentDate(date);
				List<AppMonitorReportByOwner> list = appMonitorReportService.reportByOwner(req);
				if (CollectionUtils.isNotEmpty(list)) {
					appList.addAll(list);
				}
			});
			if (CollectionUtils.isNotEmpty(appList)) {
				result.put(CacheData.getDeptMap().get(deptId), appList);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按应用维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByApp0")
	public ApiResponses<Map<String, List<AppMonitorReportByApp>>> reportByApp0(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// Key为归属项目部的名称
		Map<String, List<AppMonitorReportByApp>> result = new TreeMap<String, List<AppMonitorReportByApp>>();
		getDeptIdList(request).forEach(deptId -> {
			List<AppMonitorReportByApp> appList = new ArrayList<AppMonitorReportByApp>();
			req.setDeptId(deptId);
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {
				req.setCurrentDate(date);
				List<AppMonitorReportByApp> list = appMonitorReportService.reportByApp(req);
				if (CollectionUtils.isNotEmpty(list)) {
					appList.addAll(list);
				}
			});
			if (CollectionUtils.isNotEmpty(appList)) {
				result.put(CacheData.getDeptMap().get(deptId), appList);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按日期维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByDate1")
	public ApiResponses<List<AppMonitorReportByDate>> reportByDate1(@RequestBody AppMonitorReportRequest request) {
		List<AppMonitorReportByDate> result = new ArrayList<AppMonitorReportByDate>();
		List<String> dateList = request.getDateList();
		dateList.forEach(date -> {
			request.setCurrentDate(date);
			List<AppMonitorReportByDate> list = appMonitorReportService.reportByDate(request);
			if (CollectionUtils.isNotEmpty(list)) {
				result.addAll(list);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按归属项目部维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByDept1")
	public ApiResponses<Map<String, TreeMap<String, List<AppMonitorReportByDept>>>> reportByDept1(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// 外部Key为归属项目部的名称，内部Key为日期
		Map<String, TreeMap<String, List<AppMonitorReportByDept>>> result = new HashMap<String, TreeMap<String, List<AppMonitorReportByDept>>>();
		List<AppMonitorReportByDept> allList = new ArrayList<AppMonitorReportByDept>();
		getDeptIdList(request).forEach(deptId -> {
			TreeMap<String, List<AppMonitorReportByDept>> map = new TreeMap<String, List<AppMonitorReportByDept>>();
			List<String> dateList = request.getDateList();
			dateList.forEach(d -> {
				req.setCurrentDate(d);
				List<AppMonitorReportByDept> list = appMonitorReportService.reportByDept(req);
				allList.addAll(list);
				map.put(d, list);
			});
			result.put(CacheData.getDeptMap().get(deptId), map);
		});

		return ApiResponses.success(result);
	}

	/**
	 * 按应用负责人维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByOwner1")
	public ApiResponses<Map<String, HashMap<String, TreeMap<String, List<AppMonitorReportByOwner>>>>> reportByOwner1(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// 最外层Key为归属项目部的名称，第二层Key为应用负责人，内部Key为日期
		Map<String, HashMap<String, TreeMap<String, List<AppMonitorReportByOwner>>>> result = new HashMap<String, HashMap<String, TreeMap<String, List<AppMonitorReportByOwner>>>>();

		getDeptIdList(request).forEach(deptId -> {
			req.setDeptId(deptId);

			List<String> ownerList = new ArrayList<String>();
			if (StringUtils.isEmpty(request.getAppOwner())) {
				ownerList.addAll(CacheData.getDeptOwnerMap().get(deptId));
			} else {
				ownerList.add(request.getAppOwner());
			}
			if (CollectionUtils.isEmpty(ownerList)) {
				result.put(CacheData.getDeptMap().get(deptId),
						new HashMap<String, TreeMap<String, List<AppMonitorReportByOwner>>>());
				return;
			}
			// 外部Key为应用负责人名称，内部Key为日期
			HashMap<String, TreeMap<String, List<AppMonitorReportByOwner>>> ownerMap = new HashMap<String, TreeMap<String, List<AppMonitorReportByOwner>>>();
			ownerList.forEach(o -> {
				req.setAppOwner(o);
				// Key为日期
				TreeMap<String, List<AppMonitorReportByOwner>> dateMap = new TreeMap<String, List<AppMonitorReportByOwner>>();
				List<String> dateList = request.getDateList();
				dateList.forEach(d -> {
					req.setCurrentDate(d);
					dateMap.put(d, appMonitorReportService.reportByOwner(req));
				});
				ownerMap.put(o, dateMap);
			});
			result.put(CacheData.getDeptMap().get(deptId), ownerMap);
		});

		return ApiResponses.success(result);
	}

	/**
	 * 按应用维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByApp1")
	public ApiResponses<Map<String, HashMap<String, HashMap<String, TreeMap<String, List<AppMonitorReportByApp>>>>>> reportByApp1(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// 最外层Key为归属项目部的名称，第二层Key为应用负责人，第三层Key为应用名称，最内部Key为日期
		Map<String, HashMap<String, HashMap<String, TreeMap<String, List<AppMonitorReportByApp>>>>> result = new HashMap<String, HashMap<String, HashMap<String, TreeMap<String, List<AppMonitorReportByApp>>>>>();

		getDeptIdList(request).forEach(deptId -> {// 归属项目部的循环查询
			req.setDeptId(deptId);

			List<String> ownerList = new ArrayList<String>();
			if (StringUtils.isEmpty(request.getAppOwner())) {
				ownerList.addAll(CacheData.getDeptOwnerMap().get(deptId));
			} else {
				ownerList.add(request.getAppOwner());
			}
			if (CollectionUtils.isEmpty(ownerList)) {
				result.put(CacheData.getDeptMap().get(deptId),
						new HashMap<String, HashMap<String, TreeMap<String, List<AppMonitorReportByApp>>>>());
				return;
			}
			// 外部Key为应用负责人名称，第二层Key为应用名称，最内部Key为日期
			HashMap<String, HashMap<String, TreeMap<String, List<AppMonitorReportByApp>>>> ownerMap = new HashMap<String, HashMap<String, TreeMap<String, List<AppMonitorReportByApp>>>>();

			ownerList.forEach(owner -> {// 归属人的循环查询
				req.setAppOwner(owner);
				List<AppMonitorConfig> configList = new ArrayList<AppMonitorConfig>();
				if (request.getAppId() == null || request.getAppId() <= 0) {
					configList = CacheData.getConfigOwnerMap().get(owner);
				} else {
					configList.add(CacheData.getConfigIdMap().get(request.getAppId()));
				}
				if (CollectionUtils.isEmpty(configList)) {
					return;
				}

				// 第一层Key为应用名称，最内部Key为日期
				HashMap<String, TreeMap<String, List<AppMonitorReportByApp>>> configMap = new HashMap<String, TreeMap<String, List<AppMonitorReportByApp>>>();
				configList.forEach(config -> {// 应用监控配置的循环查询
					req.setAppId(config.getId());
					// Key为日期
					TreeMap<String, List<AppMonitorReportByApp>> dateMap = new TreeMap<String, List<AppMonitorReportByApp>>();
					List<String> dateList = request.getDateList();
					dateList.forEach(d -> {// 应用监控数据日期的循环查询
						req.setCurrentDate(d);
						dateMap.put(d, appMonitorReportService.reportByApp(req));
					});
					configMap.put(config.getAppName(), dateMap);
				});
				ownerMap.put(owner, configMap);
			});
			result.put(CacheData.getDeptMap().get(deptId), ownerMap);
		});

		return ApiResponses.success(result);
	}

	/**
	 * 按日期维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByDate2")
	public ApiResponses<List<AppMonitorReportByDate>> reportByDate2(@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		List<AppMonitorReportByDate> result = new ArrayList<AppMonitorReportByDate>();
		List<String> dateList = request.getDateList();
		dateList.forEach(d -> {
			req.setCurrentDate(d);
			List<AppMonitorReportByDate> list = appMonitorReportService.reportByDate(req);
			if (CollectionUtils.isNotEmpty(list)) {
				result.addAll(list);
			}
		});
		return ApiResponses.success(result);
	}

	/**
	 * 按归属项目部维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByDept2")
	public ApiResponses<Map<String, List<AppMonitorReportByDept>>> reportByDept2(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// 外部Key为归属项目部的名称，内部Key为日期
		Map<String, List<AppMonitorReportByDept>> result = new HashMap<String, List<AppMonitorReportByDept>>();
		getDeptIdList(request).forEach(deptId -> {
			List<AppMonitorReportByDept> deptReportList = new ArrayList<AppMonitorReportByDept>();
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {
				req.setCurrentDate(date);
				List<AppMonitorReportByDept> list = appMonitorReportService.reportByDept(req);
				if (CollectionUtils.isNotEmpty(list)) {
					deptReportList.addAll(list);
				}
			});
			if (CollectionUtils.isNotEmpty(deptReportList)) {
				result.put(CacheData.getDeptMap().get(deptId), deptReportList);
			}
		});

		return ApiResponses.success(result);
	}

	/**
	 * 按应用负责人维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByOwner2")
	public ApiResponses<Map<String, TreeMap<String, HashMap<String, List<AppMonitorReportByOwner>>>>> reportByOwner2(
			@RequestBody AppMonitorReportRequest request) {
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		// 最外层Key为归属项目部的名称，第二层Key为为日期，内部Key应用负责人
		Map<String, TreeMap<String, HashMap<String, List<AppMonitorReportByOwner>>>> result = new HashMap<String, TreeMap<String, HashMap<String, List<AppMonitorReportByOwner>>>>();

		getDeptIdList(request).forEach(deptId -> {
			request.setDeptId(deptId);

			List<String> ownerList = new ArrayList<String>();
			if (StringUtils.isEmpty(request.getAppOwner())) {
				ownerList.addAll(CacheData.getDeptOwnerMap().get(deptId));
			} else {
				ownerList.add(request.getAppOwner());
			}
			if (CollectionUtils.isEmpty(ownerList)) {
				result.put(CacheData.getDeptMap().get(deptId),
						new TreeMap<String, HashMap<String, List<AppMonitorReportByOwner>>>());
				return;
			}
			// 外层Key为日期，，内层Key为应用负责人名称
			TreeMap<String, HashMap<String, List<AppMonitorReportByOwner>>> dateMap = new TreeMap<String, HashMap<String, List<AppMonitorReportByOwner>>>();
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {
				req.setCurrentDate(date);
				// Key为应用负责人名称
				HashMap<String, List<AppMonitorReportByOwner>> ownerMap = new HashMap<String, List<AppMonitorReportByOwner>>();
				ownerList.forEach(o -> {
					req.setAppOwner(o);
					List<AppMonitorReportByOwner> ownerAppList = appMonitorReportService.reportByOwner(req);
					if (CollectionUtils.isNotEmpty(ownerAppList)) {
						ownerMap.put(o, ownerAppList);
					}
				});
				if (!ownerMap.isEmpty()) {
					dateMap.put(date, ownerMap);
				}
			});
			if (!dateMap.isEmpty()) {
				result.put(CacheData.getDeptMap().get(deptId), dateMap);
			}
		});

		return ApiResponses.success(result);
	}

	/**
	 * 按应用维度统计
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/reportByApp2")
	public ApiResponses<Map<String, TreeMap<String, HashMap<String, HashMap<String, List<AppMonitorReportByApp>>>>>> reportByApp2(
			@RequestBody AppMonitorReportRequest request) {
		
		AppMonitorReportRequest req = new AppMonitorReportRequest();
		BeanUtils.copyProperties(request, req);
		
		// 最外层Key为归属项目部的名称，第二层Key为应用负责人，第三层Key为应用名称，最内部Key为日期
		Map<String, TreeMap<String, HashMap<String, HashMap<String, List<AppMonitorReportByApp>>>>> result = new HashMap<String, TreeMap<String, HashMap<String, HashMap<String, List<AppMonitorReportByApp>>>>>();

		getDeptIdList(request).forEach(deptId -> {// 归属项目部的循环查询
			request.setDeptId(deptId);

			List<String> ownerList = new ArrayList<String>();
			if (StringUtils.isEmpty(request.getAppOwner())) {
				ownerList.addAll(CacheData.getDeptOwnerMap().get(deptId));
			} else {
				ownerList.add(request.getAppOwner());
			}
			if (CollectionUtils.isEmpty(ownerList)) {
				result.put(CacheData.getDeptMap().get(deptId),
						new TreeMap<String, HashMap<String, HashMap<String, List<AppMonitorReportByApp>>>>());
				return;
			}
			// 外部Key为日期，第二层Key为应用负责人名称，最内部Key为应用名称
			TreeMap<String, HashMap<String, HashMap<String, List<AppMonitorReportByApp>>>> dateMap = new TreeMap<String, HashMap<String, HashMap<String, List<AppMonitorReportByApp>>>>();
			List<String> dateList = request.getDateList();
			dateList.forEach(date -> {// 应用监控数据日期的循环查询
				req.setCurrentDate(date);

				// 外部Key为应用负责人名称，内部Key为应用名称
				HashMap<String, HashMap<String, List<AppMonitorReportByApp>>> ownerMap = new HashMap<String, HashMap<String, List<AppMonitorReportByApp>>>();
				ownerList.forEach(owner -> {// 归属人的循环查询
					req.setAppOwner(owner);
					List<AppMonitorConfig> configAppList = new ArrayList<AppMonitorConfig>();
					if (request.getAppId() == null || request.getAppId() <= 0) {
						configAppList = CacheData.getConfigOwnerMap().get(owner);
					} else {
						configAppList.add(CacheData.getConfigIdMap().get(request.getAppId()));
					}
					if (CollectionUtils.isEmpty(configAppList)) {
						return;
					}

					// Key为应用名称
					HashMap<String, List<AppMonitorReportByApp>> appMap = new HashMap<String, List<AppMonitorReportByApp>>();
					configAppList.forEach(app -> {// 应用监控配置的循环查询
						req.setAppId(app.getId());
						List<AppMonitorReportByApp> appList = appMonitorReportService.reportByApp(req);
						if (CollectionUtils.isNotEmpty(appList)) {
							appMap.put(app.getAppName(), appList);
						}

					});
					if (!appMap.isEmpty()) {
						ownerMap.put(owner, appMap);
					}
				});
				if (!ownerMap.isEmpty()) {
					dateMap.put(date, ownerMap);
				}
			});
			if (!dateMap.isEmpty()) {
				result.put(CacheData.getDeptMap().get(deptId), dateMap);
			}
		});

		return ApiResponses.success(result);
	}

	/**
	 * 获取查询条件中应用归属项目部的ID列表
	 * 
	 * @param request
	 * @return
	 */
	private List<Long> getDeptIdList(AppMonitorReportRequest request) {
		// 获取要查询的归属项目部的ＩＤ列表
		List<Long> deptIdList = new ArrayList<Long>();
		if (request.getDeptId() == null || request.getDeptId() <= 0) {
			// 没有传就查询全部的
			deptIdList.addAll(CacheData.getDeptMap().keySet());
		} else {
			deptIdList.add(request.getDeptId());
		}
		return deptIdList;
	}

}
