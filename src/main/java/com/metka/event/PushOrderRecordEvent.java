package com.metka.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class PushOrderRecordEvent extends ApplicationEvent {

	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public PushOrderRecordEvent(Object source,String orderNo) {
		super(source);
		this.orderNo=orderNo;
	}
	
	public PushOrderRecordEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
