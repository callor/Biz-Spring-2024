package com.callor.hello.service;

import com.callor.hello.models.UserVO;

public interface UserService {
	
	// 회원가입을 할때 사용할 method
	public UserVO createUser(UserVO createUserVO);

}
