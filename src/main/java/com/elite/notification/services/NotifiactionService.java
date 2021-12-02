package com.elite.notification.services;

import org.springframework.stereotype.Service;

import com.elite.notification.entity.Notification;
import com.elite.notification.repository.NotificationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotifiactionService {
	
	private NotificationRepository repository;

	public Notification addAccountNotification(Notification notification) {
		return repository.save(notification);
	}
}
