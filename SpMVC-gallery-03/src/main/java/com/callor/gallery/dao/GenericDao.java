package com.callor.gallery.dao;

import java.util.List;

public interface GenericDao<VO, PK> {
	
	public List<VO> selectAll();
	public VO findByid(PK pk);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
	
	public void create_table();
	
}
