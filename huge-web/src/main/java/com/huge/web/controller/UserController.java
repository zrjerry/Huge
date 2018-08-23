package com.huge.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huge.web.pojo.User;
import com.huge.web.service.UserService;
import com.jt.common.redis.RedisService;
import com.jt.common.util.CookieUtils;
import com.jt.common.vo.SysResult;

@Controller
public class UserController {
	/*
	 * 跳转到注册页面
	 * http://www.jt.com/user/register.html
	 */
	@RequestMapping("/user/register")
	public String goRegister(){
		return "register";
	}
	/*
	 * 注册方法
	 */
	@Autowired
	private UserService userService;
	@RequestMapping("/user/doRegister")
	@ResponseBody
	public SysResult doRegister(User user){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		user.setCreateTime(sdf.format(new Date()));
		System.out.println(user);
		try{
			userService.doRegister(user);
			return SysResult.oK();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201, "注册失败");
		}
	}
	/*
	 * 登录的页面跳转
	 */
	@RequestMapping("user/login")
	public String goLogin(){
		return "login";
	}
	
	/*
	 * 登录请求
	 */
	@RequestMapping("service/user/doLogin")
	@ResponseBody
	public SysResult doLogin(User user,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//user传给service,调用http访问sso
	String ticket=userService.doLogin(user);
	//ticket是否为空; 只要是null或者""都是false
	if(StringUtils.isNotEmpty(ticket)){
		//表示登录成功,将ticket写进cookie
		//common中封装了cookie的各种方法
		//COOKIE中的key定义为JT_TICKET
		CookieUtils.setCookie(request, response, 
				"HUGE_TICKET", ticket , 1000 ,false);
		return SysResult.oK(); //data:null
	}else{//登录失败,ticket是空
		return SysResult.build(201, "失败了");
	}
	}
	
	@Autowired
	private RedisService redisService;
	/*
	 * 退出登录请求
	 */
	@RequestMapping("service/user/doLogout")
	
	public String doLogout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//设置ticket为空
		//CookieUtils.setCookie(request, response, "HUGE_TICKET", "");
		//获取ticket
		String ticket = CookieUtils.getCookieValue(request, "HUGE_TICKET");
		userService.doLogout(ticket);
		return "redirect:/index";
	}
	@RequestMapping("user/findAll")
	@ResponseBody
	public List<User> findAllUser(){
		List<User> userList=userService.findAllUser();
		return userList;
		
	}

	@RequestMapping("user/findid/{id}")
	@ResponseBody
	public SysResult findUserById(@PathVariable Long id){
		try{
			System.out.println("contorller");
			User user=userService.findUserById(id);
			return SysResult.oK(user);
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201, e.getMessage());
		}
	}

	/*
	 * username查询
	 */
	@RequestMapping("user/find")
	@ResponseBody
	public List<User> findUser( String realname){
		List<User> userList=userService.findUser(realname);
		return userList;
	}
	
}

