package com.callor.gallery.service.impl;

import org.springframework.stereotype.Service;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	private final GalleryDao galleryDao;
	public GalleryServiceImpl(GalleryDao galleryDao) {
		super();
		this.galleryDao = galleryDao;
		galleryDao.create_table(null);
	}

}
