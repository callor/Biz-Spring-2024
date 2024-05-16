package com.callor.gallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.callor.gallery.config.QualifierConfig;
import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	protected final FileService fileService;
	public GalleryServiceImpl(
		@Qualifier(QualifierConfig.SERVICE.FILE_SERVICE_V2) 
				FileService fileService) {
		this.fileService = fileService;
	}

	@Override
	public List<GalleryVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createGallery() {
		// TODO Auto-generated method stub
		return 0;
	}

}
