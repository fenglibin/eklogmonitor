package com.eeeffff.monitor.eklogmonitor.common.dto.rsp;

public class AppMonitorReportByDate {
	private String createDate;
	private Integer times;
	private Integer total;

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
		return "AppMonitorReportByDate [createDate=" + createDate + ", times=" + times + ", total=" + total + "]";
	}

}
