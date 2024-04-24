package com.callor.gallery.dao;

import com.callor.gallery.models.GalleryVO;

public interface GalleryDao extends GenericCao<GalleryVO, String>{
	
	
	public void create_table(String dumy);
	

}
