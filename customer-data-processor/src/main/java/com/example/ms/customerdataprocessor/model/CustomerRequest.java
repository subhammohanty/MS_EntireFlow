package com.example.ms.customerdataprocessor.model;

import java.util.Date;




public class CustomerRequest {
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String phoneNo;
	private Date creationDate;
	private AddressRequest address;
	private SubscriptonRequest subscription;
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
	public AddressRequest getAddress() {
		return address;
	}
	public void setAddress(AddressRequest address) {
		this.address = address;
	}
	public SubscriptonRequest getSubscription() {
		return subscription;
	}
	public void setSubscription(SubscriptonRequest subscription) {
		this.subscription = subscription;
	}
	public CustomerRequest(String customerId, String firstName, String lastName, String emailId, String phoneNo,
			Date creationDate, AddressRequest address, SubscriptonRequest subscription) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.creationDate = creationDate;
		this.address = address;
		this.subscription = subscription;
	}
	public CustomerRequest() {
		super();
	}
	
	
	
	

}
