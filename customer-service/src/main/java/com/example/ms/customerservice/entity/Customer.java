package com.example.ms.customerservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	private String customerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNo;
	private Date creationDate;
	
	@OneToOne(mappedBy = "customer")
	private Address address;
	
	@OneToOne(mappedBy = "customer")
	private Subscripton subscription;
		
	public Customer() {}

	public Customer(String customer_id, String firstName, String lastName, String emailId, String phoneNo,
			Date creationDate) {
		super();
		this.customerId = customer_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.creationDate = creationDate;
	}

	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public Subscripton getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscripton subscription) {
		this.subscription = subscription;
	}
	
	

}
