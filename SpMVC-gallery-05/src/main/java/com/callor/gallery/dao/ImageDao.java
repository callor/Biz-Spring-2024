package com.callor.gallery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.gallery.models.ImagesVO;

public interface ImageDao {

	@Select("SELECT * FROM tbl_images "
			+ " WHERE i_gid = #{gid} ORDER BY i_seq ")
	public List<ImagesVO> findByGID(String gid);
	
	public void create_table();
	public int inserts(
			@Param("g_id") String g_id, 
			@Param("images") List<ImagesVO> images);

}
	
