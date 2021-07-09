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
 * app_monitor_config.
 *
 * @author autoCode
 * @version 1.0.5
 */
@TableName("app_monitor_config")
public class AppMonitorConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自增长主键.
	 */
	@TableId(value = "`id`", type = IdType.AUTO)
	private Long id;

	/**
	 * 应用监控名称描述.
	 */
	@TableField("`appName`")
	private String appName;

	/**
	 * 应用负责人.
	 */
	@TableField("`appOwner`")
	private String appOwner;

	/**
	 * Es的索引.
	 */
	@TableField("`esIndex`")
	private String esIndex;

	/**
	 * Es的查询参数,json格式.
	 */
	@TableField("`esParam`")
	private String esParam;

	/**
	 * 对应的Kibana索引.
	 */
	@TableField("`kibanaIndex`")
	private String kibanaIndex;

	/**
	 * 钉钉告警使用的accessToken.
	 */
	@TableField("`ddWebhookAccessToken`")
	private String ddWebhookAccessToken;

	/**
	 * 钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人.
	 */
	@TableField("`ddRobotMobile`")
	private String ddRobotMobile;

	/**
	 * 告警阈值,大于等于该阈值才需要告警.
	 */
	@TableField("`alarmThreshold`")
	private Integer alarmThreshold;

	/**
	 * 电话告警阈值,大于等于该阈值才需要电话告警.
	 */
	@TableField("`phoneAlarmThreshold`")
	private Integer phoneAlarmThreshold;

	/**
	 * 创建时间.
	 */
	@TableField("`createTime`")
	private LocalDateTime createTime;

	/**
	 * 创建用户id.
	 */
	@TableField("`createUserId`")
	private Integer createUserId;

	/**
	 * 更新时间.
	 */
	@TableField("`updateTime`")
	private LocalDateTime updateTime;

	/**
	 * 更新用户id.
	 */
	@TableField("`updateUserId`")
	private Integer updateUserId;

	/**
	 * 最近一次的扫描时间点,用来保证扫描不发生时间空洞.
	 */
	@TableField("`lastScanTime`")
	private LocalDateTime lastScanTime;

	/**
	 * 是否删除:1表示删除,0表示可用.
	 */
	@TableField("`isDel`")
	private Integer isDel;

	/**
	 * 任务的执行周期，以分钟为执行单位
	 */
	@TableField("`executeCycle`")
	private Integer executeCycle;

	/**
	 * 所属项目部的ID
	 */
	@TableField("`deptId`")
	private Long deptId;

	/**
	 * 测试人员的名称
	 */
	@TableField("`testerName`")
	private String testerName;

	/**
	 * 测试人员的电话，用于告警达到一定的频度时用于电话告警通知
	 */
	@TableField("`testerPhone`")
	private String testerPhone;

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
	 * 设置应用监控名称描述.
	 *
	 * @param appName 应用监控名称描述
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * 获取应用监控名称描述.
	 *
	 * @return appName 应用监控名称描述
	 */
	public String getAppName() {
		return this.appName;
	}

	/**
	 * 设置应用负责人.
	 *
	 * @param appOwner 应用负责人
	 */
	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}

	/**
	 * 获取应用负责人.
	 *
	 * @return appOwner 应用负责人
	 */
	public String getAppOwner() {
		return this.appOwner;
	}

	/**
	 * 设置Es的索引.
	 *
	 * @param esIndex Es的索引
	 */
	public void setEsIndex(String esIndex) {
		this.esIndex = esIndex;
	}

	/**
	 * 获取Es的索引.
	 *
	 * @return esIndex Es的索引
	 */
	public String getEsIndex() {
		return this.esIndex;
	}

	/**
	 * 设置Es的查询参数,json格式.
	 *
	 * @param esParam Es的查询参数,json格式
	 */
	public void setEsParam(String esParam) {
		this.esParam = esParam;
	}

	/**
	 * 获取Es的查询参数,json格式.
	 *
	 * @return esParam Es的查询参数,json格式
	 */
	public String getEsParam() {
		return this.esParam;
	}

	/**
	 * 设置对应的Kibana索引.
	 *
	 * @param kibanaIndex 对应的Kibana索引
	 */
	public void setKibanaIndex(String kibanaIndex) {
		this.kibanaIndex = kibanaIndex;
	}

	/**
	 * 获取对应的Kibana索引.
	 *
	 * @return kibanaIndex 对应的Kibana索引
	 */
	public String getKibanaIndex() {
		return this.kibanaIndex;
	}

	/**
	 * 设置钉钉告警使用的accessToken.
	 *
	 * @param ddWebhookAccessToken 钉钉告警使用的accessToken
	 */
	public void setDdWebhookAccessToken(String ddWebhookAccessToken) {
		this.ddWebhookAccessToken = ddWebhookAccessToken;
	}

	/**
	 * 获取钉钉告警使用的accessToken.
	 *
	 * @return ddWebhookAccessToken 钉钉告警使用的accessToken
	 */
	public String getDdWebhookAccessToken() {
		return this.ddWebhookAccessToken;
	}

	/**
	 * 设置钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人.
	 *
	 * @param ddRobotMobile 钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人
	 */
	public void setDdRobotMobile(String ddRobotMobile) {
		this.ddRobotMobile = ddRobotMobile;
	}

	/**
	 * 获取钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人.
	 *
	 * @return ddRobotMobile 钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人
	 */
	public String getDdRobotMobile() {
		return this.ddRobotMobile;
	}

	/**
	 * 设置告警阈值,大于等于该阈值才需要告警.
	 *
	 * @param alarmThreshold 告警阈值,大于等于该阈值才需要告警
	 */
	public void setAlarmThreshold(Integer alarmThreshold) {
		this.alarmThreshold = alarmThreshold;
	}

	/**
	 * 获取告警阈值,大于等于该阈值才需要告警.
	 *
	 * @return alarmThreshold 告警阈值,大于等于该阈值才需要告警
	 */
	public Integer getAlarmThreshold() {
		return this.alarmThreshold;
	}

	/**
	 * 获取电话告警阈值，如果没有设置就返回默认值10
	 * 
	 * @return
	 */
	public Integer getPhoneAlarmThreshold() {
		if (phoneAlarmThreshold == null || phoneAlarmThreshold == 0) {
			return 10;
		}
		return phoneAlarmThreshold;
	}

	/**
	 * 设置电话告警阈值
	 * 
	 * @param phoneAlarmThreshold
	 */
	public void setPhoneAlarmThreshold(Integer phoneAlarmThreshold) {
		this.phoneAlarmThreshold = phoneAlarmThreshold;
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

	/**
	 * 设置创建用户id.
	 *
	 * @param createUserId 创建用户id
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * 获取创建用户id.
	 *
	 * @return createUserId 创建用户id
	 */
	public Integer getCreateUserId() {
		return this.createUserId;
	}

	/**
	 * 设置更新时间.
	 *
	 * @param updateTime 更新时间
	 */
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取更新时间.
	 *
	 * @return updateTime 更新时间
	 */
	public LocalDateTime getUpdateTime() {
		return this.updateTime;
	}

	/**
	 * 设置更新用户id.
	 *
	 * @param updateUserId 更新用户id
	 */
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 * 获取更新用户id.
	 *
	 * @return updateUserId 更新用户id
	 */
	public Integer getUpdateUserId() {
		return this.updateUserId;
	}

	/**
	 * 设置最近一次的扫描时间点,用来保证扫描不发生时间空洞.
	 *
	 * @param lastScanTime 最近一次的扫描时间点,用来保证扫描不发生时间空洞
	 */
	public void setLastScanTime(LocalDateTime lastScanTime) {
		this.lastScanTime = lastScanTime;
	}

	/**
	 * 获取最近一次的扫描时间点,用来保证扫描不发生时间空洞.
	 *
	 * @return lastScanTime 最近一次的扫描时间点,用来保证扫描不发生时间空洞
	 */
	public LocalDateTime getLastScanTime() {
		return this.lastScanTime;
	}

	/**
	 * 设置是否删除:1表示删除,0表示可用.
	 *
	 * @param isDel 是否删除:1表示删除,0表示可用
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	/**
	 * 获取是否删除:1表示删除,0表示可用.
	 *
	 * @return isDel 是否删除:1表示删除,0表示可用
	 */
	public Integer getIsDel() {
		return this.isDel;
	}

	public Integer getExecuteCycle() {
		return executeCycle;
	}

	public void setExecuteCycle(Integer executeCycle) {
		this.executeCycle = executeCycle;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getTesterName() {
		return testerName;
	}

	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}

	public String getTesterPhone() {
		return testerPhone;
	}

	public void setTesterPhone(String testerPhone) {
		this.testerPhone = testerPhone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
				.append("appName", getAppName()).append("appOwner", getAppOwner()).append("esIndex", getEsIndex())
				.append("esParam", getEsParam()).append("kibanaIndex", getKibanaIndex())
				.append("ddWebhookAccessToken", getDdWebhookAccessToken()).append("ddRobotMobile", getDdRobotMobile())
				.append("alarmThreshold", getAlarmThreshold()).append("createTime", getCreateTime())
				.append("createUserId", getCreateUserId()).append("updateTime", getUpdateTime())
				.append("updateUserId", getUpdateUserId()).append("lastScanTime", getLastScanTime())
				.append("isDel", getIsDel()).append("executeCycle", getExecuteCycle()).append("deptId", getDeptId())
				.append("testerName", getTesterName()).append("testerPhone", getTesterPhone()).toString();
	}
}
