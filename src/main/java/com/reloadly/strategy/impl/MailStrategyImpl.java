package com.reloadly.strategy.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.reloadly.enums.NotificationPreference;
import com.reloadly.model.Account;
import com.reloadly.strategy.NotificationStrategy;

@Component
public class MailStrategyImpl implements NotificationStrategy {
	private static final Logger LOGGER = LoggerFactory.getLogger(MailStrategyImpl.class);
	
	@Override
	public void sendNotification(Account account, String event) {
		LOGGER.info(String.format("Send mail notification to [%s] about event [%s].", account.getEmail(), event));
	}

	@Override
	public NotificationPreference getStrategy() {
		return NotificationPreference.MAIL;
	}
}