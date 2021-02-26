package com.reloadly.strategy.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.reloadly.enums.NotificationPreference;
import com.reloadly.model.Account;
import com.reloadly.strategy.NotificationStrategy;

@Component
public class SmsStrategyImpl implements NotificationStrategy {
	private static final Logger LOGGER = LoggerFactory.getLogger(SmsStrategyImpl.class);
	
	@Override
	public void sendNotification(Account account, String event) {
		LOGGER.info(String.format("Send sms notification to [%s] about event [%s].", account.getPhone(), event));
	}

	@Override
	public NotificationPreference getStrategy() {
		return NotificationPreference.SMS;
	}
}