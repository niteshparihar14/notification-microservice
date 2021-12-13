package com.elite.notification.model;

import lombok.Data;

@Data
public class NotificationRequest {

	private String message;

	private String email;
	
	private String phone;

}
