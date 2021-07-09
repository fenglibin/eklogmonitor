/*
 * Copyright ? 2021 eeeffff.com Group All rights reserved.
 */

package com.eeeffff.monitor.eklogmonitor.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * app_monitor_data.
 *
 * @author autoCode
 * @version 1.0.0-SNAPSHOT
 */
@TableName("app_monitor_data")
public class AppMonitorData implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自增长主键.
	 */
	@TableId(value = "`id`", type = IdType.AUTO)
	private Long id;

	/**
	 * 关联配置app_monitor_config表的主键id.
	 */
	@TableField("`configId`")
	private Long configId;

	/**
	 * 错误数.
	 */
	@TableField("`errCount`")
	private Integer errCount;

	/**
	 * Kibana的URL.
	 */
	@TableField("`kibanaUrl`")
	private String kibanaUrl;

	/**
	 * 起始时间.
	 */
	@TableField("`startTime`")
	private LocalDateTime startTime;

	/**
	 * 截止时间.
	 */
	@TableField("`endTime`")
	private LocalDateTime endTime;

	/**
	 * 创建时间.
	 */
	@TableField("`createTime`")
	private LocalDateTime createTime;

	/**
	 * 当前告警的状态，0：未解决，１：已解决
	 */
	@TableField("`status`")
	private Integer status;

	/**
	 * 当前告警的关闭时间
	 */
	@TableField("`closeTime`")
	private LocalDateTime closeTime;

	/**
	 * 备注说明
	 */
	@TableField("`remark`")
	private String remark;

	/**
	 * 设置自增长主键.
	 *
	 * @param id 自增长主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取自增长主键.
	 *
	 * @return id 自增长主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 设置关联配置app_monitor_config表的主键id.
	 *
	 * @param configId 关联配置app_monitor_config表的主键id
	 */
	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	/**
	 * 获取关联配置app_monitor_config表的主键id.
	 *
	 * @return configId 关联配置app_monitor_config表的主键id
	 */
	public Long getConfigId() {
		return this.configId;
	}

	/**
	 * 设置错误数.
	 *
	 * @param errCount 错误数
	 */
	public void setErrCount(Integer errCount) {
		this.errCount = errCount;
	}

	/**
	 * 获取错误数.
	 *
	 * @return errCount 错误数
	 */
	public Integer getErrCount() {
		return this.errCount;
	}

	/**
	 * 设置Kibana的URL.
	 *
	 * @param kibanaUrl Kibana的URL
	 */
	public void setKibanaUrl(String kibanaUrl) {
		this.kibanaUrl = kibanaUrl;
	}

	/**
	 * 获取Kibana的URL.
	 *
	 * @return kibanaUrl Kibana的URL
	 */
	public String getKibanaUrl() {
		return this.kibanaUrl;
	}

	/**
	 * 设置起始时间.
	 *
	 * @param startTime 起始时间
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * 获取起始时间.
	 *
	 * @return startTime 起始时间
	 */
	public LocalDateTime getStartTime() {
		return this.startTime;
	}

	/**
	 * 设置截止时间.
	 *
	 * @param endTime 截止时间
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取截止时间.
	 *
	 * @return endTime 截止时间
	 */
	public LocalDateTime getEndTime() {
		return this.endTime;
	}

	/**
	 * 设置创建时间.
	 *
	 * @param createTime 创建时间
	 */
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取创建时间.
	 *
	 * @return createTime 创建时间
	 */
	public LocalDateTime getCreateTime() {
		return this.createTime;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("configId", getConfigId()).append("errCount", getErrCount()).append("kibanaUrl", getKibanaUrl())
				.append("startTime", getStartTime()).append("endTime", getEndTime())
				.append("createTime", getCreateTime()).append("status", getStatus()).append("closeTime", getCloseTime())
				.append("remark", getRemark()).toString();
	}
}
