package com.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	MailSender mailSender;

	public void sendEmailForSignUp(String email, String text, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setFrom("speedo321@outlook.com");
		message.setSubject(subject);
		message.setText(text);

		mailSender.send(message);
	}
}
