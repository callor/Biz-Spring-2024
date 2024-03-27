package com.callor.hello.service.impl;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public UserDto getUser() {
		UserDto user = new UserDto();
		user.setUsername("callor");
		user.setName("홍길동");
		user.setTel("010-1111-1111");
		user.setEmail("callor@callor.com");
		return user;
	}

}
