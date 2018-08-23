package com.huge.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	//跳转首页
	@RequestMapping("index")
	public String goIndex(){
		return "index";
	}
	//跳转首页
	@RequestMapping("manage")
	public String goPage(){
		return "manage";
	}
	
}
