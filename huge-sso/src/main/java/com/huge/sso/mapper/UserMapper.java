package com.huge.sso.mapper;

import com.huge.sso.pojo.User;
import com.jt.common.mapper.MyMapper;

public interface UserMapper extends MyMapper<User>{

	int checkUsername(String param);

	int checkPhone(String param);

	int checkEmail(String param);
	
	
}
