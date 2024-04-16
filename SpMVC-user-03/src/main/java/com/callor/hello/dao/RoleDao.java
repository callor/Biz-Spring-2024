package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.RoleVO;

public interface RoleDao {

	public int insertAll(List<RoleVO> roles);
	
	@Select("SELECT * FROM tbl_roles WHERE r_username = #{username}")
	public List<RoleVO> findByUserName(String username);
	
}
