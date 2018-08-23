package com.huge.manage.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.manage.mapper.ItemCatMapper;
import com.huge.manage.pojo.ItemCat;
import com.huge.manage.pojo.ItemCatResult;
import com.huge.manage.util.ItemCatUtil;
@Controller
public class WebItemCatController {
	
	/*
	 * 返回具有三级结构的分类数据ItemCatResult
	 */
	public static final ObjectMapper mapper=new ObjectMapper();
	@Autowired
	private ItemCatMapper itemCatMapper;
	@RequestMapping("web/itemcat/all")
	@ResponseBody
	
	//根据js同源策略解析成jsonp格式
	public String getAllItemCat(String callback) throws Exception{
		//获取所有分类的list
		List<ItemCat> itemCatList=itemCatMapper.selectAll();
		ItemCatResult itemCatResult = ItemCatUtil.allItemCat(itemCatList);
		String jsonData = mapper.writeValueAsString(itemCatResult);
		String jsonpData=callback+"("+jsonData+")";
		return jsonpData;
	}
}
