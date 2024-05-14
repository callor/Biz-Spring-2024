package com.callor.gallery.service;

import java.util.List;

import com.callor.gallery.models.GalleryVO;

public interface GalleryService {

	public List<GalleryVO> selectAll();
	public int createGallery();

}
