package com.eeeffff.monitor.eklogmonitor.common.dto.rsp;

/**
 * 应用异常监控配置负责人响应结果
 * @author fenglibin
 *
 */
public class AppMonitorConfigOwnerResponse {

    /**
     * 应用负责人
     */
    private String appOwner;

    public String getAppOwner() {
        return appOwner;
    }

    public void setAppOwner(String appOwner) {
        this.appOwner = appOwner;
    }

	@Override
    public String toString() {
        return "AppMonitorConfigOwnerResponse{" +
                "appOwner='" + appOwner + '\'' +
                '}';
    }
}