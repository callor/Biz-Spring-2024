package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CustomVO;

public interface CustomDao {
	
	@Select("SELECT * FROM tbl_customer")
	public List<CustomVO> selectAll();
}
