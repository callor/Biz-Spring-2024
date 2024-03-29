package com.callor.hello.service.impl;

import org.springframework.stereotype.Service;

import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

/*
 * UserServiceImpl 클래스는 userService 라는 이름의
 * Service 역할을 수행하는 컴포넌트(bean)이다 라는 선언
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Override
	public UserDto getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
