package com.eeeffff.monitor.eklogmonitor.common.dto.req;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.eeeffff.common.utils.DateTimeUtils;

public class AppMonitorReportRequest {
	private Long deptId;
	private String appOwner;
	private Long appId;
	private String startDate;
	private String endDate;
	private String currentDate;
	private Integer status;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getAppOwner() {
		return appOwner;
	}

	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 根据传入的开始日期及结束日期，以倒序的方式计算出需要查询数据的日期列表。<br>
	 * 如开始时间为2020-01-01，结束时间为2020-01-03，则返回的列表为：<br>
	 * [2020-01-03, 2020-01-02, 2020-01-01]
	 * 
	 * @return
	 */
	public List<String> getDateList() {
		List<String> list = new ArrayList<String>();
		if (StringUtils.isEmpty(startDate) && StringUtils.isEmpty(endDate)) {
			list.add(DateTimeUtils.dateToString(new Date(), DateTimeUtils.PATTERN_CLASSICAL_SIMPLE));
			return list;
		} else if (StringUtils.isNotEmpty(startDate) && StringUtils.isEmpty(endDate)) {
			list.add(startDate);
		} else if (StringUtils.isEmpty(startDate) && StringUtils.isNotEmpty(endDate)) {
			list.add(endDate);
		} else if (startDate.equals(endDate)) {
			list.add(startDate);
		} else {
			list.add(endDate);
			Date _startDate = DateTimeUtils.parse(startDate, DateTimeUtils.PATTERN_CLASSICAL_SIMPLE);
			Date _endDate = DateTimeUtils.parse(endDate, DateTimeUtils.PATTERN_CLASSICAL_SIMPLE);
			int days = DateTimeUtils.getOffsetDays(_startDate, _endDate);
			for (int i = 1; i <= days; i++) {
				list.add(DateTimeUtils.dateToString(DateTimeUtils.rollDay(_endDate, -i), DateTimeUtils.PATTERN_CLASSICAL_SIMPLE));
			}
		}
		return list;
	}

	@Override
	public String toString() {
		return "AppMonitorReportRequest [deptId=" + deptId + ", appOwner=" + appOwner + ", appId=" + appId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
}
