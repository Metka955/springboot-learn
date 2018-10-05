package com.metka;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

import com.metka.demo.Person;
import com.metka.entity.People;
import com.metka.event.PushOrderRecordEvent;
import com.metka.service.impl.TestService;
import com.metka.util.ConcurrencyTestUtil;
import com.metka.util.SpringUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
	
	@Resource
	private TestService testService;
	
	@Resource
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Test
	public void test() {
		ConcurrencyTestUtil c=ConcurrencyTestUtil.getInstance();
		c.startConcurrencyTest("http://127.0.0.1:8080/test?id=1", 10);
	}
}
