package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@MapperScan("com.huge.order.mapper")
public class OrderStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderStarter.class, args);
	}
	@RequestMapping("/")
	@ResponseBody
	public String hello(){
		return "hello order";
	}
}
