package com.huge.manage.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemCatResult {
	//一级菜单的list,返回的是分类中parent_id=0的所有分类
	@JsonProperty("data")//转化成json字符串时,当前属性的字符串名称
	private List<ItemCatData> itemCats;

	public List<ItemCatData> getItemCats() {
		return itemCats;
	}

	public void setItemCats(List<ItemCatData> itemCats) {
		this.itemCats = itemCats;
	}

	

	
	
}
