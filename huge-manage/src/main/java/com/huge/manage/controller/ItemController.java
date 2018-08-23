package com.huge.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huge.manage.pojo.Item;
import com.huge.manage.service.ItemService;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;

@Controller
public class ItemController {
	
	/*
	 * 查询所有,在这个基础上修改成分页查询
	 */
	@Autowired
	private ItemService itemService;
	@RequestMapping("item/query")
	@ResponseBody
	public EasyUIResult findItemList(Integer page,Integer rows){
		EasyUIResult itemList=itemService.findItemList(page,rows);
		return  itemList;
	}
	/*
	 * 新增商品,和商品详情
	 */
	@RequestMapping("item/save")
	@ResponseBody
	public SysResult saveItem(Item item,String desc){
		//成功插入,SysResult对象的status=200
		//如果失败,status=201,msg=失败信息;
		try{
			itemService.saveItem(item,desc);
			//返回一个带有200成功信息的SysResult对象
			//利用静态方法返回对象
			return SysResult.oK();//status=200,msg="OK"
		}catch(Exception e){
			return SysResult.build(201, e.getMessage());
		}
		
	}
	/*
	 * 商品修改,详情修改
	 */
	@RequestMapping("item/update")
	@ResponseBody
	public SysResult updateItem(Item item,String desc){
		try{
			itemService.updateItem(item,desc);
			return SysResult.oK();
		}catch(Exception e){
			return SysResult.build(201, e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
