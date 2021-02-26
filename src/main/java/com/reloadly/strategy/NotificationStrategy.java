package com.reloadly.strategy;

import com.reloadly.enums.NotificationPreference;
import com.reloadly.model.Account;

public interface NotificationStrategy {
	public void sendNotification(Account account, String event);
    
	public NotificationPreference getStrategy();
}