package com.callor.gallery.dao;

import com.callor.gallery.models.GalleryVO;

public interface GalleryDao extends GenericDao<GalleryVO, String>{
		
	public void create_table(String dumy);
	
//	public List<GalleryVO> selectAll();
//	public GalleryVO findById(String pk);
//	
//	public int insert(GalleryVO vo);
//	public int update(GalleryVO vo);
//	public int delete(String pk);

}
