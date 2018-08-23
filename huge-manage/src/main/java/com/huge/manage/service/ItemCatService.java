package com.huge.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.manage.mapper.ItemCatMapper;
import com.huge.manage.pojo.ItemCat;
import com.jt.common.redis.RedisService;

@Service
public class ItemCatService {
	@Autowired
	private ItemCatMapper itemCatMapper;
	@Autowired
	private RedisService redisService;
	public List<ItemCat> findAllItemCat() {
		/*List<ItemCat> itemCatList=itemCatMapper.
				findAllItemCat();*/
	List<ItemCat> itemCatList = itemCatMapper.selectAll();
	return itemCatList;
	}
	public static final ObjectMapper mapper=
			new ObjectMapper();
	public List<ItemCat> findListByParentId(Long id) {
	//缓存逻辑
	/*
	 * 1 生成全局位移key值,对应当前存储的数据 ITEM_CAT_ID
	 * 2 判断key值是否在缓存已有
	 * 	2.1有 数据封装直接返回controller
	 * 	2.2 没有数据表示缓存不能返回数据
	 * 		进入持久层从数据库获取数据
	 * 		与key值对应存入缓存,供后续使用
	 */
	String key="ITEM_CAT_"+id;
	//判断存在
	if(redisService.exists(key)){
		//TODO 获取数据,转化成对象,返回
		try{
		String jsonData = redisService.get(key);
		//将list的json字符串[{},{},{}] 转化成list对象;
		JsonNode data=mapper.readTree(jsonData);
		List<ItemCat> itemCatList=null;
		if(data.isArray()&&data.size()>0){
		itemCatList=mapper.readValue(data.traverse(),
				mapper.getTypeFactory().
				constructCollectionType(
						List.class, ItemCat.class));
		return itemCatList;}
		}catch(Exception e ){
			e.printStackTrace();
			
		}
		}else{
		try{
			ItemCat itemCat=new ItemCat();
			itemCat.setParentId(id);
			List<ItemCat> itemCatList = itemCatMapper.select(itemCat);
			//将对象转化成JSON存储
			
			String jsonData = mapper.writeValueAsString(itemCatList);
			//存入缓存
			redisService.set(key, jsonData);
			return itemCatList;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}
	return null;
	}

	
	
	
	
	
	
}
