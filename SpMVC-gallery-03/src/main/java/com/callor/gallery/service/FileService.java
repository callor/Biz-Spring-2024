package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	
	// Single File Upload
	public String fileUp(MultipartFile file);
	
	// Multy file Upload
	public List<String> filesUp(MultipartHttpServletRequest files);

}
