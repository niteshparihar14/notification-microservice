package com.elite.notification.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.elite.notification.entity.Notification;
import com.elite.notification.services.NotifiactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccountConsumer {
	
	@Autowired
	private NotifiactionService service;
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@KafkaListener(groupId = "Producer-Account", topics = "account-topic-1")
	public void processLoans(String account) throws JsonMappingException, JsonProcessingException{
	    System.out.println("Came inside the process method " +account);
	    Notification notification = mapper.readValue(account, Notification.class);
	    Notification notification2 = service.addAccountNotification(notification);
	    System.out.println("Notification sent " +notification2);
	}
}
