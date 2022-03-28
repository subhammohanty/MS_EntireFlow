package com.example.ms.customerservice.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.ms.customerservice.entity.Address;
import com.example.ms.customerservice.entity.Customer;
import com.example.ms.customerservice.entity.Subscripton;
import com.example.ms.customerservice.exception.UserNotFoundException;
import com.example.ms.customerservice.request.AddressRequest;
import com.example.ms.customerservice.request.SubscriptonRequest;

import graphql.GraphQLException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
	
	@Autowired
	private WebClient webClient;
	
	public List<Customer> getAllCustomer(){
		Flux<Customer> bodyToFlux = 
				webClient.get().uri("/customers").retrieve().bodyToFlux(Customer.class);
		return bodyToFlux.collect(Collectors.toList()).block();
	}
	
	
	public Customer getCustomerById(String custId) {
		Customer customer = webClient.get().uri("/customers/" + custId).retrieve()
		.onStatus(HttpStatus::is4xxClientError, customerResponse -> {
			throw new UserNotFoundException("Customer Not Found");
		}).bodyToMono(Customer.class).block();
		return customer;
	}

	public List<Customer> getFirstNCustomers(Integer limit){
		List<Customer> firstNCustomers = webClient.get().uri("/customers/limit/" + limit).retrieve()
		.bodyToFlux(Customer.class).collect(Collectors.toList()).block();		
		return firstNCustomers;
	}
	
	public String createCustomer(String customerId , String firstName, String lastName,
			String emailId, String phoneNo , Date creationDate , AddressRequest address, SubscriptonRequest subscription) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmailId(emailId);
		customer.setPhoneNo(phoneNo);
		customer.setCreationDate(new Date());
		
		Address addressObj = new Address();
		addressObj.setAddressId(address.getAddressId());
		addressObj.setAddress1(address.getAddress1());
		addressObj.setAddress2(address.getAddress2());
		addressObj.setCity(address.getCity());
		addressObj.setState(address.getState());
		addressObj.setPostalCode(address.getPostalCode());
		addressObj.setLastUpdatedDate(address.getLastUpdateDate());
		
		Subscripton subscriptionObj = new Subscripton();
//		subscriptionObj.setSubscriptionId(subscription.getSubscriptionId());
		subscriptionObj.setSubscriptionOnDate(subscription.getSubscriptionOnDate());
		subscriptionObj.setSubscriptionOffDate(subscription.getSubscriptionOffDate());
		subscriptionObj.setBalancePending(subscription.getBalancePending().longValue());
		
		customer.setAddress(addressObj);
		customer.setSubscription(subscriptionObj);
		
		Customer customerBlock = webClient.post().uri("/customer").body(Mono.just(customer) , Customer.class).retrieve()
		.onStatus(HttpStatus::is4xxClientError, response -> {
			throw new GraphQLException("Unable Save details");
		})
		.bodyToMono(Customer.class).block();
		
		return customerBlock.getCustomerId();	
	}
}
