package com.main.drawingcourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String recipient, String message, String subject) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(recipient);
            helper.setSubject(subject);

            // Set the HTML content
            helper.setText(message, true);

            javaMailSender.send(mimeMessage);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
