package com.eeeffff.monitor.eklogmonitor.alarm.phone;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

/**
 * 
 * @author fenglibin
 *
 */
@Builder
@Data
public class PhoneAlarmObj {
	@Default
	private List<String> phone_numbers = new ArrayList<String>();
	private String msg;

	/**
	 * 增加单个告警号码
	 * 
	 * @param phone
	 * @return
	 */
	public PhoneAlarmObj addPhone(String phone) {
		phone_numbers.add(phone);
		return this;
	}

	/**
	 * 增加多个告警号码
	 * 
	 * @param phoneList
	 * @return
	 */
	public PhoneAlarmObj addPhoneList(List<String> phoneList) {
		phone_numbers.addAll(phoneList);
		return this;
	}
}
