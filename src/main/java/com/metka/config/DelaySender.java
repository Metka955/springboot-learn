package com.metka.config;
 

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metka.entity.Order;
 
@Component
public class DelaySender {
 
	private static final Logger log=LoggerFactory.getLogger(DelaySender.class);

	
    @Autowired
    private AmqpTemplate amqpTemplate;
 
    public void sendDelay(Order order) {
        log.info("【订单生成时间】" + new Date().toString() +"【1分钟后检查订单是否已经支付】" + order.toString() );
        this.amqpTemplate.convertAndSend("order-delay-exchange", "order.delay.routingkey", order, message -> {
            // 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(1 * 1000 * 10 + "");
            return message;
        });
    }
}