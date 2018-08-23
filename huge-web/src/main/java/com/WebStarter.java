package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huge.web.mapper")
public class WebStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(WebStarter.class, args);
	}
}
