package com.example.ms.customerdataprocessor.model;

import java.util.Date;

public class SubscriptonRequest {
	
    private Integer subscriptionId;

    private Date subscriptionOnDate;

    private Date subscriptionOffDate;

    private Double balancePending;

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
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

	public Double getBalancePending() {
		return balancePending;
	}

	public void setBalancePending(Double balancePending) {
		this.balancePending = balancePending;
	}

	public SubscriptonRequest(Integer subscriptionId, Date subscriptionOnDate, Date subscriptionOffDate,
			Double balancePending) {
		this.subscriptionId = subscriptionId;
		this.subscriptionOnDate = subscriptionOnDate;
		this.subscriptionOffDate = subscriptionOffDate;
		this.balancePending = balancePending;
	}

	public SubscriptonRequest() {
	}
    
    

}
