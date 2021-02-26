package com.reloadly.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reloadly.model.Account;
import com.reloadly.strategy.NotificationStrategy;
import com.reloadly.strategy.NotificationStrategyFactory;

@Service
public class NotificationService {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${app.account-ms.url}")
	private String accountServiceUrl;
	@Autowired
	private NotificationStrategyFactory notificationStrategyFactory;
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

	@RabbitListener(queues = "${app.queue}")
	public void processMessage(String message) {
		String[] tokens = message.split(",");

		Long accountId = Long.valueOf(tokens[0]);
		String event = tokens[1];

		try {
			ResponseEntity<Account> account = this.restTemplate.getForEntity(new URI(accountServiceUrl + accountId),
					Account.class);

			if (HttpStatus.OK.equals(account.getStatusCode())) {
				NotificationStrategy notificationStrategy = this.notificationStrategyFactory.findStrategy(account.getBody().getNotificationPreference());
				notificationStrategy.sendNotification(account.getBody(), event);
			}
		} catch (Exception e) {
			LOGGER.error("Notification creation failed.", e);
		}
	}
}