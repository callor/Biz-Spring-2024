package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.model.UserVO;

public interface UserDao {

	public List<UserVO> selectAll();
	
	
}
