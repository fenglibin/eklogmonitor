package com.eeeffff.monitor.eklogmonitor.common.dto.rsp;

import java.time.LocalDateTime;

/**
 * 配置详情对象
 * @author fenglibin
 *
 */
public class AppMonitorConfigResponse {

    /**
     * 自增长主键.
     */
    private Long id;

    /**
     * 应用监控名称描述.
     */
    private String appName;

    /**
     * 应用负责人.
     */
    private String appOwner;

    /**
     * Es的索引.
     */
    private String esIndex;

    /**
     * Es的查询参数,json格式.
     */
    private String esParam;

    /**
     * 钉钉告警使用的accessToken.
     */
    private String ddWebhookAccessToken;

    /**
     * 钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人.
     */
    private String ddRobotMobile;

    /**
     * 告警阈值,大于等于该阈值才需要告警.
     */
    private Integer alarmThreshold;
    
    /**
	 * 电话告警阈值,大于等于该阈值才需要电话告警.
	 */
	private Integer phoneAlarmThreshold;

    /**
     * 最近一次的扫描时间点
     */
    private LocalDateTime lastScanTime;
    
    /**
	 * 任务的执行周期，以分钟为执行单位
	 */
    private Integer executeCycle;
    
    /**
     * 归属部门ID
     */
    private Long deptId;
    
    /**
     * 归属部门名称
     */
    private String deptName;

    /**
	 * 测试人员的名称
	 */
	private String testerName;

	/**
	 * 测试人员的电话，用于告警达到一定的频度时用于电话告警通知
	 */
	private String testerPhone;
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppOwner() {
        return appOwner;
    }

    public void setAppOwner(String appOwner) {
        this.appOwner = appOwner;
    }

    public String getEsIndex() {
        return esIndex;
    }

    public void setEsIndex(String esIndex) {
        this.esIndex = esIndex;
    }

    public String getEsParam() {
        return esParam;
    }

    public void setEsParam(String esParam) {
        this.esParam = esParam;
    }

    public String getDdWebhookAccessToken() {
        return ddWebhookAccessToken;
    }

    public void setDdWebhookAccessToken(String ddWebhookAccessToken) {
        this.ddWebhookAccessToken = ddWebhookAccessToken;
    }

    public String getDdRobotMobile() {
        return ddRobotMobile;
    }

    public void setDdRobotMobile(String ddRobotMobile) {
        this.ddRobotMobile = ddRobotMobile;
    }

    public Integer getAlarmThreshold() {
        return alarmThreshold;
    }

    public void setAlarmThreshold(Integer alarmThreshold) {
        this.alarmThreshold = alarmThreshold;
    }

    public Integer getPhoneAlarmThreshold() {
		return phoneAlarmThreshold;
	}

	public void setPhoneAlarmThreshold(Integer phoneAlarmThreshold) {
		this.phoneAlarmThreshold = phoneAlarmThreshold;
	}

	public LocalDateTime getLastScanTime() {
        return lastScanTime;
    }

    public void setLastScanTime(LocalDateTime lastScanTime) {
        this.lastScanTime = lastScanTime;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	@Override
    public String toString() {
        return "AppMonitorConfigResponse{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", appOwner='" + appOwner + '\'' +
                ", esIndex='" + esIndex + '\'' +
                ", esParam='" + esParam + '\'' +
                ", ddWebhookAccessToken='" + ddWebhookAccessToken + '\'' +
                ", ddRobotMobile='" + ddRobotMobile + '\'' +
                ", alarmThreshold=" + alarmThreshold +
                ", phoneAlarmThreshold=" + phoneAlarmThreshold +
                ", lastScanTime=" + lastScanTime +
                ", executeCycle=" + executeCycle +
                ", deptId=" + deptId +
                ", deptName=" + deptName +
                ", testerName=" + testerName +
                ", testerPhone=" + testerPhone +
                '}';
    }
}