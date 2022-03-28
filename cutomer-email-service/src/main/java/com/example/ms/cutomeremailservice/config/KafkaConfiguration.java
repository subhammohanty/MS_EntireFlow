package com.example.ms.cutomeremailservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.streams.HeaderEnricher.Container;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.ms.cutomeremailservice.model.CustomerRequest;


@Configuration
public class KafkaConfiguration {
	
	public ConsumerFactory<String, CustomerRequest> consumerFactory(){
		
		 JsonDeserializer<CustomerRequest> deserializer = new JsonDeserializer<>(CustomerRequest.class);
		    deserializer.setRemoveTypeHeaders(false);
		    deserializer.addTrustedPackages("*");
		    deserializer.setUseTypeMapperForKey(true);
		    
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "mygroup_json");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);
		
		return new DefaultKafkaConsumerFactory<String, CustomerRequest>(config, new StringDeserializer(),
				deserializer);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CustomerRequest> kafkaListnerContainerFactoryJson(){
		ConcurrentKafkaListenerContainerFactory<String , CustomerRequest> factory = new ConcurrentKafkaListenerContainerFactory<String , CustomerRequest>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
		
	}

}
