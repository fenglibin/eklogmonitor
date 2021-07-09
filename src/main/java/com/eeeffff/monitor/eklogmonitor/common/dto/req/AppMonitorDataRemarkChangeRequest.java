package com.eeeffff.monitor.eklogmonitor.common.dto.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * 监控问题备注的更新
 * 
 * @author fenglibin
 *
 */
public class AppMonitorDataRemarkChangeRequest {

	@NotNull
	@Positive
	private Long id;
	/**
	 * 当前任务的告警说明
	 */
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "AppMonitorDataRemarkChangeRequest{" + "id=" + id + ", remark=" + remark + '}';
	}
}