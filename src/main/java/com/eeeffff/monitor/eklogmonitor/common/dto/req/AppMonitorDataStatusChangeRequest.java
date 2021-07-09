package com.eeeffff.monitor.eklogmonitor.common.dto.req;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * 监控状态的更新
 * @author fenglibin
 *
 */
public class AppMonitorDataStatusChangeRequest {

	@NotNull
	@Positive
	private Long id;
	/**
	 * 当前告警的状态，0：未解决，１：已解决
	 */
	private Integer status;
	/**
	 * 告警的解决时间
	 */
	private LocalDateTime closeTime = LocalDateTime.now();

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalDateTime closeTime) {
		this.closeTime = closeTime;
	}

	@Override
    public String toString() {
        return "AppMonitorDataStatusChangeRequest{" +
                "id=" + id +
                ", status=" + status +
                ", closeTime=" + closeTime +
                '}';
    }
}