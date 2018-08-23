package com.huge.web.mapper;

import java.util.List;

import com.huge.web.pojo.User;
import com.jt.common.mapper.MyMapper;

public interface UserMapper extends MyMapper<User>{

	public User findUserById(Long id);

	public List<User> findUser(String realname);
	
}
