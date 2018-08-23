package com.huge.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.web.pojo.Cart;
import com.huge.web.pojo.Order;
import com.jt.common.service.HttpClientService;
import com.jt.common.vo.SysResult;

@Service
public class OrderService {
	@Autowired
	private HttpClientService client;
	public static final ObjectMapper mapper=new ObjectMapper();
	public List<Cart> queryCartList(Long userId) throws Exception {
		//httpclient从cart系统获取数据
		String url="http://cart.jt.com/cart/query/"+userId;
		String jsonData = client.doGet(url);
		SysResult result = mapper.readValue(jsonData, SysResult.class);
		List<Cart> cartList=(List<Cart>)result.getData();
		return cartList;
	}
	public String submit(Order order) throws Exception {
		//httpclient传递json参数
		String url="http://order.jt.com/order/create";
		String orderJson=mapper.writeValueAsString(order);
		String jsonData=client.doPostJson(url, orderJson);//接收后台的orderId
		SysResult result=mapper.readValue(jsonData, SysResult.class);
		String orderId=(String)result.getData();
		return orderId;
	}
	public Order queryOrderById(String id) throws Exception {
		String url="http://order.jt.com/order/query/"+id;
		String orderJson=(String)client.doGet(url);
		Order order=mapper.readValue(orderJson, Order.class);
		return order;
	}
	
	public Integer cancel(Order order) throws Exception {
		String url="http://order.jt.com/order/cancel";
		String orderJson = mapper.writeValueAsString(order);
		String jsonData = client.doPostJson(url, orderJson);
		SysResult result = mapper.readValue(jsonData, SysResult.class);
		Integer orderCancel = (Integer)result.getData();
		return orderCancel;
	}
	
}
