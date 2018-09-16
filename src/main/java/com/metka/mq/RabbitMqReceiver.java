/*package com.metka.mq;

import java.io.IOException;
import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.Channel;

@Configuration
public class RabbitMqReceiver {

	*//**
	 * 
	 * @param msg 消息的类型
	 * @param headers  消息头信息
	 * @throws IOException 
	 *//*
	@RabbitListener(queues= {"test_queue"})
	@RabbitHandler
	public void receiver(Message msg,Channel channel) throws IOException  {
		System.out.println(msg);
		//channel.basicAck(channel.getChannelNumber(), true);
	}
}
*/