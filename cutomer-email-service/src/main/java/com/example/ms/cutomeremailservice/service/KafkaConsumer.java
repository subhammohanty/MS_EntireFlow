package com.example.ms.cutomeremailservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.ms.cutomeremailservice.model.CustomerRequest;

@Service
public class KafkaConsumer {
	
	@Autowired
	private EmailSenderService mailService;
	
	
	@KafkaListener(topics = "Kafka_Example_Json2" , groupId="mygroup_json" , containerFactory = "kafkaListnerContainerFactoryJson")
	public void consumeFromTopic(CustomerRequest customerRequest) {
		System.out.println("Consumed message Before Mail: " + customerRequest.getEmailId());
		sendMail(customerRequest);
		System.out.println("Consumed message After Mail: ");
	}

	
	public void sendMail(CustomerRequest customerRequest) {
		String message = "Congratulations! Youa re now been subscribed ! Your Customer Id is " + customerRequest.getCustomerId();
		mailService.sendEmail(customerRequest.getEmailId(), "This is Subject", message);
	}
}
