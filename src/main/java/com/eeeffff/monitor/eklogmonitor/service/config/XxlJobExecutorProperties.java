package com.eeeffff.monitor.eklogmonitor.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 *
 * @author fenglibin
 *
 */
@ConfigurationProperties(prefix = "xxl.job")
@Component
@Data
public class XxlJobExecutorProperties {

    private String adminAddresses;

    private String executorAppName;

    private int executorPort;

    private String executorLogPath;
}