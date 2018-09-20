package com.metka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;



@MapperScan("com.metka.mapper")
@SpringBootApplication
@EnableCaching
@EnableAsync
public class Application {
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		//xixi
	}
}
