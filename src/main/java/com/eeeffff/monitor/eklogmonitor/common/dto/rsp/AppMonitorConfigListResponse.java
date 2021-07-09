package com.eeeffff.monitor.eklogmonitor.common.dto.rsp;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 应用异常监控配置列表响应结果
 * 
 * @author fenglibin
 *
 */
public class AppMonitorConfigListResponse {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 监控项目名称
     */
    private String appName;

    /**
     * 应用负责人
     */
    private String appOwner;

    /**
     * Es的索引
     */
    private String esIndex;

    /**
     * 钉钉告警群中@相关人员的手机号码列表:多个用逗号分隔,不配置默认@所有人
     */
    private String ddRobotMobile;
    
    /**
	 * 任务的执行周期，以分钟为执行单位
	 */
    private Integer executeCycle;
    
    /**
     * 所属项目部的ID.
     */
    private Long deptId;
    
    /**
     * 所属项目部的名称.
     */
    private String deptName;
    
    /**
	 * 告警阈值,大于等于该阈值才需要告警.
	 */
	private Integer alarmThreshold;
	
	/**
	 * 电话告警阈值,大于等于该阈值才需要电话告警.
	 */
	private Integer phoneAlarmThreshold;
	
	/**
	 * 测试人员的名称
	 */
	private String testerName;

	/**
	 * 测试人员的电话，用于告警达到一定的频度时用于电话告警通知
	 */
	private String testerPhone;
	
    /**
     * 创建时间.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUserName;

    /**
     * 更新时间.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    private String updateUserName;

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

    public String getDdRobotMobile() {
        return ddRobotMobile;
    }

    public void setDdRobotMobile(String ddRobotMobile) {
        this.ddRobotMobile = ddRobotMobile;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
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
        return "AppMonitorConfigListResponse{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", appOwner='" + appOwner + '\'' +
                ", esIndex='" + esIndex + '\'' +
                ", ddRobotMobile='" + ddRobotMobile + '\'' +
                ", createTime=" + createTime +
                ", createUserName='" + createUserName + '\'' +
                ", updateTime=" + updateTime +
                ", updateUserName='" + updateUserName + '\'' +
                ", executeCycle='" + executeCycle + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", alarmThreshold='" + alarmThreshold + '\'' +
                ", phoneAlarmThreshold='" + phoneAlarmThreshold + '\'' +
                ", testerName='" + testerName + '\'' +
                ", testerPhone='" + testerPhone + '\'' +
                '}';
    }
}