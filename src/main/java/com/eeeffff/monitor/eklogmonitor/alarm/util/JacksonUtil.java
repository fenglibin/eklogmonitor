package com.eeeffff.monitor.eklogmonitor.alarm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author fenglibin
 *
 */
public class JacksonUtil {
	private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

	private final static ObjectMapper objectMapper = new ObjectMapper();

	public static ObjectMapper getInstance() {
		return objectMapper;
	}

	/**
	 * <pre>{@code bean、array、List、Map --> json}</pre>
	 * 
	 * @param obj
	 * @return json string
	 */
	public static String writeValueAsString(Object obj) {
		try {
			return getInstance().writeValueAsString(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}
