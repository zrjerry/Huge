package com.huge.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.web.pojo.Cart;
import com.huge.web.pojo.Item;
import com.jt.common.service.HttpClientService;
import com.jt.common.vo.SysResult;


@Service
public class CartService {
	@Autowired
	private HttpClientService client;
	public static final ObjectMapper mapper=new ObjectMapper();
	public List<Cart> myCart(Long userId) throws Exception {
		String url="http://cart.jt.com/cart/query/"+userId;
		String jsonData=client.doGet(url);
		SysResult result = mapper.readValue
				(jsonData, SysResult.class);
		//cart返回结果放入sysResult的是list对象,如果是json字符
		List<Cart> cartList=(List<Cart>)result.getData();
		return cartList;
	}
	public void addCart(Long userId, Long itemId, Integer num) throws Exception {
		//在前台代码封装好传递的参数六个
		//调用httpclient从后台获取数据
		String url="http://manage.jt.com/items/"+itemId;
		String itemJson=client.doGet(url);
		Item item = mapper.readValue(itemJson, Item.class);
		//数据获取完毕
		//调用方法,将六个参数封装 按照给cart的接口文件封装
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("userId", userId);
		params.put("itemId", itemId);
		params.put("num", num);
		params.put("itemTitle", item.getTitle());
		//想办法从image中获取第一张图片
		params.put("itemImage", item.getImage().split(",")[0]);
		params.put("itemPrice", item.getPrice());
		url="http://cart.jt.com/cart/save";
		client.doPost(url, params);
		
		
		
	}
	public void updateNum(Long userId, Long itemId, Integer num) throws Exception {
		String url="http://cart.jt.com/cart/update/num/"
				+userId+"/"+itemId+"/"+num;
		client.doGet(url);
		
	}
	public void deleteCart(Long userId, Long itemId) throws Exception {
		String url="http://cart.jt.com/cart/delete/"
				+userId+"/"+itemId;
		client.doGet(url);
		
	}

}
