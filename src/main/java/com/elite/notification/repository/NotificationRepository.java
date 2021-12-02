package com.elite.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elite.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
