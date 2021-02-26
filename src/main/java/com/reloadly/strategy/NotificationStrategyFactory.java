package com.reloadly.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.reloadly.enums.NotificationPreference;

@Component
public class NotificationStrategyFactory {
	private Map<NotificationPreference, NotificationStrategy> strategies;

	public NotificationStrategyFactory(Set<NotificationStrategy> strategySet) {
	     createStrategyMap(strategySet);
	}

	public NotificationStrategy findStrategy(NotificationPreference notificationPreference) {
		return strategies.get(notificationPreference);
	}

	private void createStrategyMap(Set<NotificationStrategy> strategySet) {
		strategies = new HashMap<NotificationPreference, NotificationStrategy>();
		strategySet.forEach(strategy -> strategies.put(strategy.getStrategy(), strategy));
	}
}