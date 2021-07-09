package com.eeeffff.monitor.eklogmonitor.common.dto.req;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 应用异常配置保存、编辑对象
 * @author fenglibin
 *
 */
public class AppMonitorConfigRequest {

    /**
     * 自增长主键.
     */
    private Long id;

    /**
     * 应用监控名称描述.
     */
    @NotBlank(message = "应用监控名称不能为空")
    private String appName;

    /**
     * 应用负责人.
     */
    @NotBlank(message = "应用负责人不能为空")
    private String appOwner;

    /**
     * Es的索引.
     */
    @NotBlank(message = "Es索引不能为空")
    private String esIndex;

    /**
     * Es的查询参数,json格式.
     */
    @NotBlank(message = "Es查询参数不能为空")
    private String esParam;

    /**
     * 钉钉告警使用的accessToken.
     */
    @NotBlank(message = "钉钉告警机器人accessToken不能为空")
    private String ddWebhookAccessToken;

    /**
     * 钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人.
     */
    private String ddRobotMobile;

    /**
     * 告警阈值,大于等于该阈值才需要告警.
     */
    @Positive
    @Min(value = 1,message = "异常数阈值不能小于1")
    private Integer alarmThreshold;
    
    /**
     * 电话告警阈值,大于等于该阈值才需要告警.
     */
    private Integer phoneAlarmThreshold;

    /**
     * 最近一次的扫描时间点
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastScanTime;
    
    /**
	 * 任务的执行周期，以分钟为执行单位
	 */
    @Positive
    private Integer executeCycle;

    /**
     * 操作人用户Id
     */
    private Integer optUserId;
    
    /**
     * 归属部门ID
     */
    private Long deptId;
    
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

    public Integer getOptUserId() {
        return optUserId;
    }

    public void setOptUserId(Integer optUserId) {
        this.optUserId = optUserId;
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

	@Override
    public String toString() {
        return "AppMonitorConfigRequest{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", appOwner='" + appOwner + '\'' +
                ", esIndex='" + esIndex + '\'' +
                ", esParam='" + esParam + '\'' +
                ", ddWebhookAccessToken='" + ddWebhookAccessToken + '\'' +
                ", ddRobotMobile='" + ddRobotMobile + '\'' +
                ", alarmThreshold=" + alarmThreshold +
                ", lastScanTime=" + lastScanTime +
                ", optUserId=" + optUserId +
                ", executeCycle=" + executeCycle +
                ", deptId=" + deptId +
                ", testerName=" + testerName +
                ", testerPhone=" + testerPhone +
                '}';
    }
}