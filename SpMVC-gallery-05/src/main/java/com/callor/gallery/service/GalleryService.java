package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.GalleryVO;

public interface GalleryService {
	
	
	public List<GalleryVO> selectAll();
	public GalleryVO selectGalleryOne(String gid);
	
	public int createGalleys(GalleryVO galleryVO, 
			MultipartHttpServletRequest files);
	public int delete(String id);

}
