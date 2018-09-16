package com.metka;



import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.metka.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
	
	@Resource
	RabbitTemplate rabbitTemplate;
	
	@Test
	public void test() {
		rabbitTemplate.setConfirmCallback(new ConfirmCallback() {
			
			@Override
			public void confirm(CorrelationData correlationData, boolean ack, String cause) {
				// TODO Auto-generated method stub
				System.out.println(ack);
			}
		});
		User user=new User();
		user.setUsername("ddddddd");
		String userJson = JSON.toJSONString(user);
		CorrelationData correlationData=new CorrelationData();
		correlationData.setId("1");
		rabbitTemplate.convertAndSend("test_exchange", "add.2", userJson, correlationData);
	}
}
