package com.metka.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.metka.event.PushOrderRecordEvent;

@Component
public class PushOrderRecordListener implements ApplicationListener<PushOrderRecordEvent> {

	@Async
	@Override
	public void onApplicationEvent(PushOrderRecordEvent event) {
		// TODO Auto-generated method stub
		System.out.println("监听器:  " +event.getOrderNo()+Thread.currentThread().getName());
	}

}
