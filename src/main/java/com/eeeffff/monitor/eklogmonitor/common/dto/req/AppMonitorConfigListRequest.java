package com.eeeffff.monitor.eklogmonitor.common.dto.req;

/**
 * 应用异常监控配置列表请求参数
 *
 * @author fenglibin
 *
 */
public class AppMonitorConfigListRequest {
	/**
	 * 应用归属项目部的ＩＤ
	 */
	private Long deptId;
	/**
	 * 负责人的名称
	 */
	private String appOwner;
	/**
     * 配置Id
     */
    private Long configId;
    /**
     * 监控项目名称
     */
    private String appName;

    /**
     * 告警手机号码
     */
    private String alarmMobile;
    
    /**
	 * 测试人员的名称
	 */
	private String testerName;

	/**
	 * 测试人员的电话，用于告警达到一定的频度时用于电话告警通知
	 */
	private String testerPhone;

    /**
     * ES索引
     */
    private String esIndex;

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

	public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAlarmMobile() {
        return alarmMobile;
    }

    public void setAlarmMobile(String alarmMobile) {
        this.alarmMobile = alarmMobile;
    }

    public String getEsIndex() {
        return esIndex;
    }

    public void setEsIndex(String esIndex) {
        this.esIndex = esIndex;
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
        return "AppMonitorConfigListRequest{" +
        		"deptId='" + deptId + '\'' +
        		", appOwner='" + appOwner + '\'' +
        		", configId='" + configId + '\'' +
                ", appName='" + appName + '\'' +
                ", alarmMobile='" + alarmMobile + '\'' +
                ", esIndex='" + esIndex + '\'' +
                ", testerName='" + testerName + '\'' +
                ", testerPhone='" + testerPhone + '\'' +
                '}';
    }
}