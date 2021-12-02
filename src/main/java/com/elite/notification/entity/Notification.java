package com.elite.notification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Notification")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "customerid")
	private Long customerId;

	@Column(name = "emailaddress")
	private String emailAddress;

	@Column(name = "message")
	private String message;

	@Column(name = "phone")
	private String phone;
}
