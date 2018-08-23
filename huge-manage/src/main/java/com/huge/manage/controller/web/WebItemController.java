package com.huge.manage.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huge.manage.mapper.ItemMapper;
import com.huge.manage.pojo.Item;

@Controller
public class WebItemController {
	/*
	 * 利用id获取item信息
	 */
	@Autowired
	private ItemMapper itemMapper;
	
	@RequestMapping("items/{itemId}")
	@ResponseBody
	public Item findItemById(@PathVariable Long itemId){
		return itemMapper.selectByPrimaryKey(itemId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
