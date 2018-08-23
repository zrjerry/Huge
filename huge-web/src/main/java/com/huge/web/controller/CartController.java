package com.huge.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huge.web.pojo.Cart;
import com.huge.web.service.CartService;

@Controller
public class CartController {
	/*
	 * 查询购物车,同时跳转页面,
	 * www.jt.com/show
	 */
	@Autowired
	private CartService cartService;
	@RequestMapping("cart/show")
	public String myCart(HttpServletRequest request,Model model) throws Exception{
		//userId的获取是通过拦截器完成的,没有拦截器功能
		//暂时手动定义一个固定的7
		//Long userId=7l;
		//通过拦截器获取的userId,从request对象来
	Long userId=(long)request.getAttribute("userId");
	List<Cart> cartList=	cartService.myCart(userId);
	model.addAttribute("cartList", cartList);
		return "cart";
	}
	
	/*
	 * 新增购物车商品
	 */
	@RequestMapping("cart/add/{itemId}")
	public String addCart(@PathVariable Long itemId,
			Integer num,HttpServletRequest request) throws Exception{
		Long userId=(long)request.getAttribute("userId");
		cartService.addCart(userId,itemId,num);
		return "redirect:/cart/show.html";//单独页面解析渲染,导致当前转向的cart没有数据
	}
	/*
	 * 修改商品数量
	 */
	@RequestMapping("cart/update/num/{itemId}/{num}")
	public String updateNum(HttpServletRequest request,
			@PathVariable Long itemId,@PathVariable Integer num) throws Exception{
		Long userId=(long) request.getAttribute("userId");
		cartService.updateNum(userId,itemId,num);
		return "";
	}
	/*
	 * 删除购物车
	 */
	@RequestMapping("cart/delete/{itemId}")
	public String deleteCart(HttpServletRequest request,
			@PathVariable Long itemId) throws Exception{
		Long userId=(long) request.getAttribute("userId");
		cartService.deleteCart(userId,itemId);
		return "redirect:/cart/show.html";
	}	
}
