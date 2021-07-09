package com.eeeffff.monitor.eklogmonitor.common.dto.rsp;

public class AppMonitorReportByApp {
	private Long deptId;
	private String deptName;
	private String appOwner;
	private Long appId;
	private String appName;
	private String createDate;
	private Integer times;
	private Integer total;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "AppMonitorReportByApp [deptId=" + deptId + ", deptName=" + deptName + ", appOwner=" + appOwner
				+ ", appId=" + appId + ", appName=" + appName + ", createDate=" + createDate + ", times=" + times
				+ ", total=" + total + "]";
	}

}
