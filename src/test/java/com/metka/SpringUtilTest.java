package com.metka;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.metka.demo.Person;
import com.metka.util.SpringUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringUtilTest {
	
	@Resource
	SpringUtil springUtil;
	
	@Test
	public void test_1() {
		ApplicationContext applicationContext = springUtil.getApplicationContext();
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
		for (String b : beanNamesForType) {
			System.out.println(b);
			
		}
	}
}
