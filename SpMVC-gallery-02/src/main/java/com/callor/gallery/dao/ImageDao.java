package com.callor.gallery.dao;

import com.callor.gallery.models.ImageVO;

public interface ImageDao extends GenericCao<ImageVO, String>{

	public void create_table(String string);

}
