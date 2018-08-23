package com.huge.manage.mapper;

import java.util.List;

import com.huge.manage.pojo.ItemCat;
import com.jt.common.mapper.MyMapper;



public interface ItemCatMapper extends MyMapper<ItemCat>{

	List<ItemCat> findAllItemCat();

}
