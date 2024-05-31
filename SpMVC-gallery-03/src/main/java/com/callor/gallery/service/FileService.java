package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.ImageVO;

public interface FileService {
	
	// Single File Upload
	public String fileUp(MultipartFile file) throws Exception;
	
	// Multy file Upload
	public List<ImageVO> filesUp(MultipartHttpServletRequest files) throws Exception;

}
