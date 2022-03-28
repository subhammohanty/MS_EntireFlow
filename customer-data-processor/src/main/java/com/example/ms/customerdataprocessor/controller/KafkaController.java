package com.example.ms.customerdataprocessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms.customerdataprocessor.model.CustomerRequest;
import com.example.ms.customerdataprocessor.service.KafkaProducer;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/kafkaapp")
public class KafkaController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@PostMapping("/publish")
	public Mono<String> sendMessage(@RequestBody CustomerRequest customerRequest) {
		kafkaProducer.publishToTopic(customerRequest);
//		Mono<String> mono = "Hello";		
		return  Mono.just("Mail Send Sucessfully");
	}
	

	@GetMapping("/demo")
	public String demo() {
		return "Hello";
	}
}
