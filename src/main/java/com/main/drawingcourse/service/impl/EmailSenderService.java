package com.main.drawingcourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender emailSender;
	
	public void sendEmail(String toEmail,String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("leehai1107@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		emailSender.send(message);
	}

}
