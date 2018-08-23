package com.huge.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.web.pojo.User;
import com.jt.common.service.HttpClientService;
import com.jt.common.util.CookieUtils;
import com.jt.common.vo.SysResult;

public class OrderInterceptor implements HandlerInterceptor{
	@Autowired
	private HttpClientService client;
	private static final ObjectMapper mapper=new ObjectMapper();
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1 判断登录,通过cookie判断
		//2 如果登录成功,ticket userJson都存在,将userId
		//获取,放到request作用域返回true,传给controller
		//3 不成功,表示没登录,转向登录;返回false
		String ticket=CookieUtils.getCookieValue
				(request, "HUGE_TICKET");
		if(StringUtils.isNotEmpty(ticket)){
			//表示有值,但是未必登录.获取userJson判断登录
			String url="http://sso.jt.com/user/query/"
			+ticket;
			//获取json字符串,有可能是空的
			String jsonData = client.doGet(url);
			if(StringUtils.isNotEmpty(jsonData)){
				SysResult result=mapper.readValue(jsonData, SysResult.class);
			String userJson=(String)result.getData();
			User user=mapper.readValue(userJson, User.class);
				Long userId=user.getId();
			request.setAttribute("userId", userId);
				return true;//放行,传给controller;
			}
		}
		//如果代码没有进入第二个if表示登录失败,转向登录页面
		response.sendRedirect("/user/login.html");
		return false;//如果逻辑返回true表示request请求放行;
		//false表示不放行;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
