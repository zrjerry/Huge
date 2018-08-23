package com.huge.order.mapper;

import java.util.List;

import com.huge.order.pojo.Order;
import com.huge.order.pojo.OrderItem;

public interface OrderMapper {
	
	public Order queryOrder(String orderId);
	public void saveOrder(Order order);
	public int cancelOrder(Order order);
	public List<OrderItem> findAllOrder(String userId);
}
