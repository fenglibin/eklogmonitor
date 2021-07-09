package com.eeeffff.monitor.eklogmonitor.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.eeeffff.monitor.eklogmonitor.AbstractSpringBootTest;
import com.eeeffff.monitor.eklogmonitor.service.config.AppMonitorProperties;


/**
 *
 * @author fenglibin
 *
 */
public class ElasticSearchPropertiesTest extends AbstractSpringBootTest {

    @Autowired
    private AppMonitorProperties elasticSearchProperties;

    @Test
    public void testSelect() {
        Assert.assertNotNull(elasticSearchProperties.select());
    }
}