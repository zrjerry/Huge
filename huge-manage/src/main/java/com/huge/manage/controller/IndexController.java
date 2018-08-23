package com.huge.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	/*
	 * 访问首页 动态获取页面渲染
	 *page/index
	 */
	@RequestMapping("page/{index}")
	public String goPages(@PathVariable String index){
		return index;
	}
}
