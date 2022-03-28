package com.example.ms.customerdataprocessor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.ms.customerdataprocessor.model.CustomerRequest;

@Service
public class KafkaProducer {
	
	public static final String topic = "Kafka_Example_Json2";
	
	@Autowired
	private KafkaTemplate<String, CustomerRequest> kafkaTemp;
	
	
	public void publishToTopic(CustomerRequest customerRequest) {
		System.out.println("Publishing to topic :" + topic);
		String message = "Congratulations! Youa re now been subscribed !";
		kafkaTemp.send(topic , customerRequest);
	}

}
