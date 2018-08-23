package com.huge.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.web.mapper.UserMapper;
import com.huge.web.pojo.User;
import com.jt.common.service.HttpClientService;
import com.jt.common.vo.HttpResult;
import com.jt.common.vo.SysResult;

@Service
public class UserService {
	@Autowired
	private HttpClientService client;
	/*
	 * 调用httpclient传递参数 user
	 */
	//post还是get 
	//username=sadl&password=12213&email=12123&phone=12393712

	public void doRegister(User user) throws Exception {
		//url地址 对接SSO单点登录的接口文件
		String url="http://localhost:8092/user/register";
		//user信息风准过到map中,属性名是key,属性值是value
		Map<String,Object> params=new 
				HashMap<String,Object>();
		params.put("identityId", user.getIdentityId());
		params.put("username", user.getUsername());
		params.put("realname", user.getRealname());
		params.put("password", user.getPassword());
		params.put("gender", user.getGender());
		params.put("createTime", user.getCreateTime());
		params.put("email", user.getEmail());
		System.out.println(user);
	/*	params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		params.put("phone", user.getPhone());
		params.put("email", user.getPhone());*/
		//调用client传递参数访问sso
		HttpResult result = client.doPost(url, params);
		result.getBody();//sso返回的json字符串 sysresult
	}
	public static final ObjectMapper mapper=new ObjectMapper();
	
	
	
	public String doLogin(User user) throws Exception {
		//传参给sso
		String url ="http://sso.huge.com/user/login";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("u", user.getUsername());
		params.put("p", user.getPassword());
		HttpResult result = client.doPost(url,params);
		System.out.println("result" + result); //resultcom.jt.common.vo.HttpResult@6b070e5b
		String jsonData = result.getBody();//获取sysresult的字符串其中data属性保存这ticket
		System.out.println("jsonData" + jsonData); //jsonData{"status":200,"msg":"OK","data":"4ddda71681db4c778156f80c62e6da19","ok":true}
		SysResult sysResult = mapper.readValue(jsonData, SysResult.class);
		String ticket=(String)sysResult.getData();
		System.out.println("ticketweb" + ticket); //ticketweb4ddda71681db4c778156f80c62e6da19
		return ticket;
	}
	
	
	
	/*
	 * 登出
	 */
	public void doLogout(String ticket) throws Exception {
		String url ="http://sso.huge.com/user/logout";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("ticket", ticket);
		client.doPost(url,params);
		
	}
	@Autowired
	private UserMapper userMapper;
	public List<User> findAllUser() {
		List<User> userList=userMapper.selectAll();
		return userList;
	}
	
	public User findUserById(Long id) {
		System.out.println("service");
		User user=userMapper.findUserById(id);
		return user;
	}

	public List<User> findUser(String realname) {
		List<User> userList=userMapper.findUser(realname);
		return userList;
	}
	
	
	
}
