package com.example.ms.customerservice.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Subscripton {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subscriptionId;
	private Date subscriptionOnDate;
	private Date subscriptionOffDate;
	private Long balancePending;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;
	

	public Subscripton() {}

	public Subscripton(int subscriptionId, Date subscriptionOnDate, Date subscriptionOffDate, Long balancePending) {
		super();
		this.subscriptionId = subscriptionId;
		this.subscriptionOnDate = subscriptionOnDate;
		this.subscriptionOffDate = subscriptionOffDate;
		this.balancePending = balancePending;
	}

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Date getSubscriptionOnDate() {
		return subscriptionOnDate;
	}

	public void setSubscriptionOnDate(Date subscriptionOnDate) {
		this.subscriptionOnDate = subscriptionOnDate;
	}

	public Date getSubscriptionOffDate() {
		return subscriptionOffDate;
	}

	public void setSubscriptionOffDate(Date subscriptionOffDate) {
		this.subscriptionOffDate = subscriptionOffDate;
	}

	public Long getBalancePending() {
		return balancePending;
	}

	public void setBalancePending(Long balancePending) {
		this.balancePending = balancePending;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
