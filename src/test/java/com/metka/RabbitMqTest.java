package com.metka;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.metka.config.DelaySender;
import com.metka.entity.Order;
import com.metka.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

	private static final Logger log = LoggerFactory.getLogger(RabbitMqTest.class);

	@Resource
	RabbitTemplate rabbitTemplate;

	@Autowired
	private DelaySender delaySender;

	@Test
	public void sendDelay() {
		Order order1 = new Order();
		order1.setOrderStatus(0);
		order1.setOrderId("123456");
		order1.setOrderName("小米6");

		Order order2 = new Order();
		order2.setOrderStatus(1);
		order2.setOrderId("456789");
		order2.setOrderName("小米8");

		delaySender.sendDelay(order1);
		delaySender.sendDelay(order2);
		try {
			Thread.sleep(1000*70);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		rabbitTemplate.setConfirmCallback(new ConfirmCallback() {

			@Override
			public void confirm(CorrelationData correlationData, boolean ack, String cause) {
				// TODO Auto-generated method stub
				System.out.println(ack);
			}
		});
		User user = new User();
		user.setUsername("ddddddd");
		String userJson = JSON.toJSONString(user);
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId("1");
		rabbitTemplate.convertAndSend("test_exchange", "add.2", userJson, correlationData);
	}
}
