package com.huge.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huge.manage.mapper.ItemDescMapper;
import com.huge.manage.pojo.ItemDesc;

@Service
public class ItemDescService {
	@Autowired
	private ItemDescMapper itemDescMapper;
	public ItemDesc findItemDescById(Long itemId) {
		ItemDesc itemDesc = 
				itemDescMapper.selectByPrimaryKey(itemId);
		return itemDesc;
	}

}
