package com.eeeffff.monitor.eklogmonitor.common.dto.rsp;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 应用异常监控数据列表响应结果
 * 
 * @author fenglibin
 *
 */
public class AppMonitorDataListResponse {

    /**
     * 主键id
     */
    private Long id;
    
    /**
     * 归属部门ID
     */
    private Long deptId;
    
    /**
     * 归属部门名称
     */
    private String deptName;

    /**
     * 监控项目名称
     */
    private String appName;

    /**
     * 应用负责人
     */
    private String appOwner;

    /**
     * 错误数.
     */
    private Integer errCount;

    /**
     * Kibana的URL.
     */
    private String kibanaUrl;
    
    /**
	 * 备注说明
	 */
	private String remark;
    
    /**
	 * 当前告警的状态，0：未解决，１：已解决
	 */
	private Integer status;
	/**
	 * 当前告警的关闭时间
	 */
	private LocalDateTime closeTime;

    /**
     * 起始时间.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * 截止时间.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getErrCount() {
        return errCount;
    }

    public void setErrCount(Integer errCount) {
        this.errCount = errCount;
    }

    public String getKibanaUrl() {
        return kibanaUrl;
    }

    public void setKibanaUrl(String kibanaUrl) {
        this.kibanaUrl = kibanaUrl;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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
        return "AppMonitorDataListResponse{" +
                "id=" + id +
                ", deptId='" + deptId + '\'' +
                ", deptName='" + deptName + '\'' +
                ", appName='" + appName + '\'' +
                ", appOwner='" + appOwner + '\'' +
                ", errCount=" + errCount +
                ", kibanaUrl='" + kibanaUrl + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", closeTime=" + closeTime +
                ", remark=" + remark +
                '}';
    }
}