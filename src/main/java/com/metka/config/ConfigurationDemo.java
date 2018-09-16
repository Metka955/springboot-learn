package com.metka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.metka.demo.Person;

@Import(Person.class)
@Configuration
public class ConfigurationDemo {
	
	@Bean
	public Person person() {
		System.out.println();
		return new Person("aaa",1);
	}
}
