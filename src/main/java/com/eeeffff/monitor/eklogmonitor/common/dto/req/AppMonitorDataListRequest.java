package com.eeeffff.monitor.eklogmonitor.common.dto.req;

/**
 * 应用异常监控数据列表请求参数
 *
 * @author fenglibin
 *
 */
public class AppMonitorDataListRequest {
	/**
	 * 应用归属项目部的ＩＤ
	 */
	private Long deptId;
	/**
	 * 应用配置负责人的名称
	 */
	private String appOwner;
    /**
     * 配置Id
     */
    private Long configId;
    
    /**
     * 当前状态：0表示未处理，1表示已处理
     */
    private Integer status;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 截止时间
     */
    private String endTime;

    private int pageNum = 1;

    private int pageSize = 10;

    public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getAppOwner() {
		return appOwner;
	}

	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}

	public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "AppMonitorDataListRequest{" +
        		"deptId=" + deptId +
        		", appOwner=" + appOwner +
                ", configId=" + configId +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}