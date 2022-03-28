package com.example.ms.customerservice.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.ms.customerservice.entity.Customer;
import com.example.ms.customerservice.service.CustomerService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

@DgsComponent
public class Query implements GraphQLQueryResolver{
	
	@Autowired
	private CustomerService customerService;
	
	@DgsQuery
	public List<Customer> getAllCustomers(){
		return  customerService.getAllCustomer();
	}
	
	@DgsQuery
	public Customer getCustomerById(String customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@DgsQuery
	public List<Customer> getFirstNCustomer(Integer limit){
		return customerService.getFirstNCustomers(limit);
	}

}
