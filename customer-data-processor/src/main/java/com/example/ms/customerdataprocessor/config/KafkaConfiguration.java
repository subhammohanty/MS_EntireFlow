package com.example.ms.customerdataprocessor.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.ms.customerdataprocessor.model.CustomerRequest;


@Configuration
public class KafkaConfiguration {
	
	public ProducerFactory<String, CustomerRequest> producerFactory(){

		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<String, CustomerRequest>(config);
	}
	
	@Bean
	KafkaTemplate<String, CustomerRequest> kafkaTemplate(){
		return new KafkaTemplate<String, CustomerRequest>(producerFactory());
	}

}
