package com.eeeffff.monitor.eklogmonitor.common.dto.rsp;

public class AppMonitorReportByOwner {
	private Long deptId;
	private String deptName;
	private String appOwner;
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
		return "AppMonitorReportByDateResponse [deptId=" + deptId + ", deptName=" + deptName + ", appOwner=" + appOwner
				+ ", createDate=" + createDate + ", times=" + times + ", total=" + total + "]";
	}

}
