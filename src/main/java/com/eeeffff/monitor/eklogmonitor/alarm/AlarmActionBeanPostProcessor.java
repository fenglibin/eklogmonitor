package com.eeeffff.monitor.eklogmonitor.alarm;

import java.lang.reflect.Modifier;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * 系统启动时自动发现AlarmAction的实现
 * 
 * @author fenglibin
 *
 */
@Slf4j
@Service
public class AlarmActionBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof AlarmAction && !Modifier.isAbstract(bean.getClass().getModifiers())) {
			log.info("Add alarm action service implemention:" + bean.getClass().getName());
			AlarmAction alarmAction = (AlarmAction) bean;
			AlarmAction.addAlarmAction(alarmAction);
		}
		return bean;
	}

}
