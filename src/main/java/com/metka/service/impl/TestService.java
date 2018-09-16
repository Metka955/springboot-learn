package com.metka.service.impl;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.metka.entity.People;

@Configuration
@Service
public class TestService {
	
	public String test() {
		return "success";
	}
	
	public People getPeople() {
		return this.p;
	}
	
	private static People p;
	
	@Bean
	@ConfigurationProperties(prefix="people")
	public People getPeople(People people) {
		return new People();
	}
}
