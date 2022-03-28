package com.example.ms.customerservice.mutation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.ms.customerservice.request.AddressRequest;
import com.example.ms.customerservice.request.SubscriptonRequest;
import com.example.ms.customerservice.response.CustomerCreated;
import com.example.ms.customerservice.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;

@DgsComponent
public class Mutation implements GraphQLMutationResolver{
	
	@Autowired
	private CustomerService customerService;
	
	@DgsMutation
	public CustomerCreated createCustomer(String customerId , String firstName, String lastName,
			String emailId, String phoneNo , Date creationDate , AddressRequest address, SubscriptonRequest subscription) {
		return new CustomerCreated(customerService.createCustomer(customerId, firstName, lastName, emailId, phoneNo, creationDate, address, subscription));
	}

}
