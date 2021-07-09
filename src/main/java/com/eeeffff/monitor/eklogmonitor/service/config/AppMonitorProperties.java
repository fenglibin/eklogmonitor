package com.eeeffff.monitor.eklogmonitor.service.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;

import lombok.Data;

/**
 * ES的配置项
 * @author fenglibin
 *
 */
@ConfigurationProperties(prefix = "app.monitor")
@Component
@Data
public class AppMonitorProperties {
	
	/**
	 * 任务检查的间隔时间
	 */
	private final long taskIntervalSeconds = 60;

    /**
     * ES的访问地址,是个集群，所以有多个url
     */
    private List<String> esUrLList;

    /**
     * ES的访问用户名
     */
    private String esUsername;

    /**
     * ES的访问密码
     */
    private String esPassword;

    /**
     * 钉钉机器人推送url
     *
     */
    private String ddWebhookUrl;
    
    /**
     * 往钉钉发送消息的时候有频率限制，钉钉默认每分钟最多可以发送20条
     */
    private int ddSendEveryMinute;
    
    /**
     * ES搜索的模板
     */
    private String esTemplate="{\"query\":{\"bool\":{\"must\":[${query},{\"range\":{\"@timestamp\":{\"gte\":\"${startTime}\",\"lte\":\"${endTime}\",\"time_zone\": \"Asia/Shanghai\"}}}]}}}";

    /**
     * Kibana KQL bool
     */
    private List<String> kibanaKeywordList= Lists.newArrayList("must","filter","should","must_not");

    /**
     * Kibana 模板
     */
    private String kibanaTemplate;

    /**
     * Kibana查询index pattern的url
     */
    private String kibanaQueryIndexUrl;
    
    /**
     * 产生电话告警时，需要额外通知的用户
     */
    private Map<Long,String> phoneAlertExtraUsers;

    /**
     * 从ES集群中选择一个uri
     * @return
     */
    public final String select(){
        if (CollectionUtils.isEmpty(esUrLList)) {
            return null;
        }
        if (esUrLList.size() == 1) {
            return esUrLList.get(0);
        }
        int length = esUrLList.size();
        return esUrLList.get(ThreadLocalRandom.current().nextInt(length));
    }
}