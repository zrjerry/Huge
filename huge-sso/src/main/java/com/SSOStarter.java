package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huge.sso.mapper")
public class SSOStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(SSOStarter.class, args);
	}
}
