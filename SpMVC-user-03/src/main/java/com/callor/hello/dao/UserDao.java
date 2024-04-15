package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.UserVO;

public interface UserDao {
	
	public List<UserVO> selectAll();
	
	@Select("SELECT * FROM tbl_users WHERE username = #{username}")
	public UserVO findById(String username);
	
	public int insert(UserVO userVO);
	public int update(UserVO userVO);
	public int delete(String username);
	
	public void create_user_table(String dumy);
	public void create_role_table(String dumy);


}
