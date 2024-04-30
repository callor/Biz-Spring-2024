package com.callor.gallery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.gallery.dao.RoleDao;
import com.callor.gallery.dao.UserDao;
import com.callor.gallery.models.UserVO;
import com.callor.gallery.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private final UserDao userDao;
	private final RoleDao roleDao;
	public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
		super();
		this.userDao = userDao;
		this.roleDao = roleDao;
	}
	

	@Override
	public int create_user(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Autowired
	@Override
	public void create_table() {
		try {
			userDao.create_table(null);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			roleDao.create_table(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
