package com.huge.order.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.huge.order.mapper.OrderMapper;
import com.huge.order.pojo.Order;
import com.huge.order.pojo.OrderItem;

@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	public static final ObjectMapper mapper = new ObjectMapper();

	public Order queryOrder(String orderId) {
		return orderMapper.queryOrder(orderId);

	}

	public String saveOrder(Order order) throws Exception {
		// 解析Order对象,是没有orderId的对象
		// 利用计算方法将orderId字符串创建出来
		// userId+currentTime
		String orderId = order.getUserId() + "" + System.currentTimeMillis();
		order.setOrderId(orderId);
		// 写入数据库
		orderMapper.saveOrder(order);
		return orderId;
	}

	public Integer cancelOrder(String orderJson) throws Exception {
		// 解析order对象,修改订单状态
		Order order = mapper.readValue(orderJson, Order.class);
		Integer orderCancel = order.getStatus();
		// status=1成功 status=2取消
		if (orderCancel != 2) {
			order.setStatus(2);
			orderMapper.cancelOrder(order);
			return 2;
		}
		System.out.println(orderCancel);
		return orderCancel;
	}


	public List<OrderItem> findAllOrder(String userId) {
		return orderMapper.findAllOrder(userId);
	}

}
