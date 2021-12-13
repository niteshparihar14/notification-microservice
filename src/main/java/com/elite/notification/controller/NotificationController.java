package com.elite.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elite.notification.entity.Notification;
import com.elite.notification.model.NotificationRequest;
import com.elite.notification.services.NotifiactionService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(path = "/api/v1")
@Transactional(rollbackFor = { Exception.class })
public class NotificationController {
	
	@Autowired
	private NotifiactionService service;

	@PostMapping(path = "/notifications/customer/{customerId}")
	public ResponseEntity<Notification> addEntity(@RequestBody NotificationRequest request,
			@PathVariable("customerId") Long customerId) throws JsonProcessingException {
		Notification notification = new Notification();
		notification.setCustomerId(customerId);
		notification.setEmailAddress(request.getEmail());
		notification.setPhone(request.getPhone());
		notification.setMessage(request.getMessage());
		service.addAccountNotification(notification);
		
		return ResponseEntity.ok().body(notification);
	}

}
