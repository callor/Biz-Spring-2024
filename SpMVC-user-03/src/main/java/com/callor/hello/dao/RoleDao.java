package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.models.RoleVO;

public interface RoleDao {

	public int insertAll(List<RoleVO> roles);
	public List<RoleVO> findByUserName(String username);
	
}
