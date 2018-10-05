
package com.metka.listener;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.metka.entity.Order;
import com.rabbitmq.client.Channel;

@Component
public class DelayReceiver {

	private static final Logger log=LoggerFactory.getLogger(DelayReceiver.class);

	@RabbitListener(queues = { "order-queue" })
	public void orderDelayQueue(Order order, Message message, Channel channel) {
		log.info("###########################################");
		log.info("【orderDelayQueue 监听的消息】 - 【消费时间】 - [{}]- 【订单内容】 - [{}]", new Date(), order.toString());
		if (order.getOrderStatus() == 0) {
			order.setOrderStatus(2);
			log.info("【该订单未支付，取消订单】" + order.toString());
		} else if (order.getOrderStatus() == 1) {
			log.info("【该订单已完成支付】");
		} else if (order.getOrderStatus() == 2) {
			log.info("【该订单已取消】");
		}
		log.info("###########################################");
	}
}