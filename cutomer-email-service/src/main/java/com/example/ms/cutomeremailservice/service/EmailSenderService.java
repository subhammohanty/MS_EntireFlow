package com.example.ms.cutomeremailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String userName;
	
	public void sendEmail(String toEmail , String subject , String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(userName);
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		mailSender.send(message);
		
		System.out.println("mail Send Sucessfully : {} ");
	}
	

}
