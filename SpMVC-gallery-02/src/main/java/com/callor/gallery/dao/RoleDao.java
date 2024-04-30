package com.callor.gallery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.gallery.models.RoleVO;

public interface RoleDao extends GenericDao<RoleVO, String>{
	
	public int inserts(
			@Param("roles") List<RoleVO> vo,
			@Param("username") String username);

	@Select("SELECT * FROM tbl_roles WHERE r_username =#{user}")
	public List<RoleVO> findByUsername(String username);

}
