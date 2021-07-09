package com.eeeffff.monitor.eklogmonitor.alarm;

import java.util.ArrayList;
import java.util.List;

import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorConfig;
import com.eeeffff.monitor.eklogmonitor.dao.entity.AppMonitorData;

/**
 * 
 * @author fenglibin
 *
 */
public abstract class AlarmAction {

	private static List<AlarmAction> alarmList = new ArrayList<AlarmAction>();

	/**
	 * 执行告警的任务，需要实现具体的告警任务
	 * 
	 * @param config
	 * @param data
	 */
	public abstract void doAlarm(AppMonitorConfig config, AppMonitorData data);

	/**
	 * 告警任务的顺序，默认值为0，值越小越优先执行
	 * 
	 * @return 告警任务的顺序，默认值为0，值越小越优先执行
	 */
	public int getOrder() {
		return 0;
	}

	/**
	 * 调用所有的AlarmAction，并执行告警操作
	 */
	public static void executeAlarm(AppMonitorConfig config, AppMonitorData data) {
		if(alarmList.size()==0) {
			return;
		}
		alarmList.forEach(a->{
			a.doAlarm(config, data);
		});

	}

	/**
	 * 将AlarmAction增加到处理列表中，并自动排序，order越小的越排在前面
	 * 
	 * @param alarmAction
	 */
	public static void addAlarmAction(AlarmAction alarmAction) {
		alarmList.add(alarmAction);
		if (alarmList.size() <= 1) {
			return;
		}
		// order值小的排在前面
		alarmList.sort((a1, a2) -> {
			if (a1.getOrder() > a2.getOrder()) {
				return 1;
			} else if (a1.getOrder() < a2.getOrder()) {
				return -1;
			} else {
				return 0;
			}
		});
	}
}
