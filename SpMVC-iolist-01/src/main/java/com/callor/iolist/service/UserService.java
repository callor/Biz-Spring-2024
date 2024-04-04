package com.callor.iolist.service;

import com.callor.iolist.models.UserVO;

public interface UserService {
	
	public UserVO login(String username, String password);

}
