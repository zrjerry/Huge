package com.huge.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.sso.pojo.User;
import com.huge.sso.service.UserService;
import com.jt.common.vo.SysResult;

@Controller
public class UserController {
	
	/*
	 * 注册数据的校验
	 */
	@Autowired
	private UserService userService;
	public static final ObjectMapper mapper=new ObjectMapper();
	@RequestMapping("user/check/{param}/{type}")
	@ResponseBody
	public String check(@PathVariable String param,
			@PathVariable Integer type,String callback) throws Exception{
		Boolean exists=userService.check(param,type);
		//说明已经存在,返回data=true的sysresult
		SysResult result = SysResult.oK(exists);
		//result对象转化成json,拼接callback
		String jsonData = mapper.writeValueAsString(result);
		return callback+"("+jsonData+")";
	}
	//用户的注册
	@RequestMapping("user/register")
	@ResponseBody
	public SysResult register(User user){
		userService.register(user);
		return SysResult.oK(user.getUsername());
	}
	//用户登录逻辑
	@RequestMapping("user/login")
	@ResponseBody
	public SysResult login(@RequestParam("u")String username,
			String p) throws Exception{
		//RequestParam可以定义接收的名称,赋值给方便阅读的参数
		SysResult result=userService.login(username,p);
		return result;
	}
	//检测user信息
		@RequestMapping("user/query/{ticket}")
		@ResponseBody
		public String query(String callback,
				@PathVariable String ticket) throws Exception{
		String userJson=userService.getUserJsonByTicket(ticket);
		//System.out.println("userJson..." + userJson);
		SysResult result = SysResult.oK(userJson);
		//System.out.println("result" + result);
		//转化字符串
		String jsonData = mapper.writeValueAsString(result);
		//System.out.println("jsonData controller" + jsonData);
		if(StringUtils.isNotEmpty(callback)){
			//有表示js的jsonp数据格式要求
			System.err.println("进后台了callback");
			return callback+"("+jsonData+")";
		}else{
			//没有表示httpclient请求不需要callback拼接
			System.err.println("进后台了");
			return jsonData;
		}
		
		}
		
		
		/*
		 * 用户退出逻辑
		 */
		@RequestMapping("user/logout")
		public void logout(@RequestParam("ticket")String ticket){
			userService.logout(ticket);
		}
}
