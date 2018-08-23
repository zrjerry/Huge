package com.huge.sso.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huge.sso.mapper.UserMapper;
import com.huge.sso.pojo.User;
import com.jt.common.redis.RedisService;
import com.jt.common.vo.SysResult;

@Service
public class UserService {
	@Autowired 
	private UserMapper userMapper;
	public Boolean check(String param, Integer type) {
		Boolean exists=false;
		if(type==1){
			//TODO 表示使用mapper查询用户 where username=param
			//select count(*) from tb_user where username = param
			int count=userMapper.checkUsername(param);
			if(count>=1){
				exists=true;
			}
			return exists;
		}else if(type==2){
			//TODO 表示查询电话
			int count=userMapper.checkPhone(param);
			if(count>=1){
				exists=true;
			}
			return exists;
		}else{
			//TODO 查邮箱
			int count=userMapper.checkEmail(param);
			if(count>=1){
				exists=true;
			}
			return exists;
		}
		
	}
	public void register(User user) {
		//补齐数据created upated
		//密码加密
//		user.setCreated(new Date());
//		user.setUpdated(user.getCreated());
//		String md5pw = DigestUtils.md5Hex(user.getPassword());
//		System.out.println(md5pw);
//		user.setPassword(md5pw);
//		user.setPassword(user.getPassword());
		userMapper.insert(user);
	}
	//用户登录
	@Autowired
	private RedisService redisService;
	public static final ObjectMapper mapper=new ObjectMapper();
	public SysResult login(String username, String p) throws Exception {
		String ticket="";
		//检测合法
		int count = userMapper.checkUsername(username);
		if(count>=1){//说明有username,判断密码匹配
		//中间参数的user
		User _user=new User();
		_user.setUsername(username);
		List<User> userList = userMapper.select(_user);
		//获取user数据
		User user=userList.get(0);
		//判断比较密码
//			String md5p=DigestUtils.md5Hex(p);
//			if(md5p.equals(user.getPassword())){
			if(p.equals(user.getPassword())) {
			//此时用户合法
			//生成ticket,存入redis,供后续使用
			//ticket就是存入redis的key值
			//ticket=DigestUtils.md5Hex("HUGE_TICKET_"+System.currentTimeMillis()+username);
				ticket = username;
			//user转化成json字符串存入redis
			String userJson=mapper.writeValueAsString(user);
			redisService.set(ticket, userJson);
			System.out.println("ticket" + ticket); //ticket423640d1913b427afdad37f3f1bc1539
			}
		}
		return SysResult.oK(ticket);
	}
	public String getUserJsonByTicket(String ticket) {
		System.out.println("ticket---" + ticket);
		String userJson = redisService.get(ticket);
		
		return userJson;
	}

	public void logout(String ticket) {
		redisService.set(ticket, "");
		
	}
}
