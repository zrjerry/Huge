package com.huge.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huge.web.pojo.Cart;
import com.huge.web.pojo.Order;
import com.huge.web.service.OrderService;
import com.jt.common.vo.SysResult;

@Controller
public class OrderController {
	/*
	 * 从购物车跳转向订单信息收集页面
	 * order-cart.jsp
	 * order/create.html
	 */
	@Autowired
	private OrderService orderService;
	@RequestMapping("order/create")
	public String create(HttpServletRequest request,Model model) throws Exception{
		
		Long userId=(long)request.getAttribute("userId");
		List<Cart> cartList=orderService.queryCartList(userId);
		// 将商品信息传入创建订单
//		model.addAttribute("carts", cartList);
		return "order-cart";
	}
	/*
	 * 接收订单参数创建订单
	 */
	@RequestMapping("order/submit")
	@ResponseBody
	public SysResult submit(Order order,HttpServletRequest request) throws Exception{
		Long userId=(long)request.getAttribute("userId");
		order.setUserId(userId);
		//service方法创建order
		String orderId=orderService.submit(order);
		return SysResult.oK(orderId);
	}
	
	/*
	 * 退票业务
	 */
	@RequestMapping("order/cancel")
	@ResponseBody
	public SysResult cancel(String id,HttpServletRequest request) throws Exception{
		Order order=orderService.queryOrderById(id);
		if(order!=null) {
			Integer status = orderService.cancel(order);
			// 退票成功,跳转页面
			return SysResult.oK(status);
		}
		else {
			return SysResult.build(201, "失败了");
		}
	}
	//转向成功页面
	@RequestMapping("order/success")
	public String success(String id,Model model) throws Exception{
		Order order=orderService.queryOrderById(id);
		model.addAttribute("order", order);
		return "success";//转向success.jsp
	}
	
}
