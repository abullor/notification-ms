package com.reloadly.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reloadly.enums.NotificationPreference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
	private Long id;
	private String name;
	private Boolean active;
	private String email;
	private String phone;
	private NotificationPreference notificationPreference;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public NotificationPreference getNotificationPreference() {
		return notificationPreference;
	}
	public void setNotificationPreference(NotificationPreference notificationPreference) {
		this.notificationPreference = notificationPreference;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", active=" + active + ", email=" + email + ", phone=" + phone
				+ ", notificationPreference=" + notificationPreference + "]";
	}
}