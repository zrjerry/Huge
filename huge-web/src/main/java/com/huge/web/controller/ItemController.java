package com.huge.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huge.web.pojo.Item;
import com.huge.web.service.ItemService;
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	/*
	 * 获取商品信息,到前台页面展示
	 */
	@RequestMapping("/items/{itemId}")
	public String getItem(@PathVariable Long itemId,
			Model model){
	Item item=itemService.getItem(itemId);
	//利用模版对象,将观察到的el表达式的key值封装数据
	model.addAttribute("item", item);
	//model.addAttribute("itemDesc", itemDesc);
	return "item";
	}
}
