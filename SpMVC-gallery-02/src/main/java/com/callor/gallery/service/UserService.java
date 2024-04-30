package com.callor.gallery.service;

import com.callor.gallery.models.UserVO;

public interface UserService {
	
	public void create_table();
	public int create_user(UserVO userVO);

}
