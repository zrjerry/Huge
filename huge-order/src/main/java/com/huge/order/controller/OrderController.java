package com.huge.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.order.pojo.Order;
import com.huge.order.pojo.OrderItem;
import com.huge.order.service.OrderService;
import com.jt.common.vo.SysResult;

@RestController
public class OrderController {

	/*
	 * 根据订单id查询订单数据返回json字符串
	 */
	@Autowired
	private OrderService orderService;
	@RequestMapping("order/query/{orderId}")
	public Order queryOrder(@PathVariable String orderId){
		//orderId 字符串类型,是在创建时手动编写;
		System.out.println(orderId);
		Order order=orderService.queryOrder(orderId);
		return order;
	}
	/*
	 * 创建订单
	 *http://order.jt.com/order/create
	 */
	@RequestMapping("order/create")
	@ResponseBody
	public String orderCreate(Order order,String callback) throws Exception{
		//orderJson不存在orderId
		//需要业务层将orderId创建后封装到方法里调用持久层
		//写入数据库
		System.out.println("进");
		String orderId=orderService.saveOrder(order);
		SysResult result = SysResult.oK(orderId);
		String jsonData = MAPPER.writeValueAsString(result);
		return callback+"("+jsonData+")";
	}
	/*
	 * 取消订单
	 */
	@RequestMapping("order/cancel")
	@ResponseBody
	public SysResult orderCancel(@RequestBody String orderJson) throws Exception{
		// 将订单的状态修改为已取消
		Integer orderStatus = orderService.cancelOrder(orderJson);
		return SysResult.oK(orderStatus);
	}
	/*
	 * 查询用户的所有订单
	 * public String check(@PathVariable String param,
			@PathVariable Integer type,String callback) throws Exception{
		Boolean exists=userService.check(param,type);
		//说明已经存在,返回data=true的sysresult
		SysResult result = SysResult.oK(exists);
		//result对象转化成json,拼接callback
		String jsonData = mapper.writeValueAsString(result);
		return callback+"("+jsonData+")";
	}
	 */
	@Autowired
	private static final ObjectMapper MAPPER = new ObjectMapper(); 
	@RequestMapping("order/findAllOrder")
//	,String callback
	public String findAllOrder(String userId,String callback) throws Exception{
		System.out.println(123456777);
		List<OrderItem> list = orderService.findAllOrder(userId);
		SysResult result = SysResult.oK(list);
		String jsonData = MAPPER.writeValueAsString(result);
//		return jsonData;
		return callback+"("+jsonData+")";
	}
}
