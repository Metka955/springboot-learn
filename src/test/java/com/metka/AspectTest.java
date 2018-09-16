package com.metka;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metka.service.impl.TestAspectImpl;

@SpringBootTest
@RunWith(value = SpringRunner.class)
public class AspectTest{
	
	@Resource
	TestAspectImpl testAspectImpl;
	
	@Test
	public void test1() {
		testAspectImpl.test("success",1);
	}
}
