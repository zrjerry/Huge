package com.huge.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huge.manage.pojo.ItemCat;
import com.huge.manage.service.ItemCatService;

@Controller
public class ItemCatController {
	
	/*
	 * 测试访问tb_item_cat表获取所有数据
	 * 返回json字符串
	 */
	@Autowired
	private ItemCatService itemCatService;
	@RequestMapping("findAllItemCat")
	@ResponseBody
	public List<ItemCat> findAllItemCat(){
	List<ItemCat> itemCatList=itemCatService.findAllItemCat();
	return itemCatList;
	}
	
	/*
	 * 商品分类树展示
	 */
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<ItemCat> findListByParentId(
			@RequestParam(defaultValue="0")Long id){
		//初次访问,初始值需要是0
		//利用parent_id=#{id}来获取
		 List<ItemCat> itemCatList=	
				 itemCatService.findListByParentId(id);
		 return itemCatList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
