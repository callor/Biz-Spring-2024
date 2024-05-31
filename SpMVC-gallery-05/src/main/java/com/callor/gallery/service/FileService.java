package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.ImagesVO;

public interface FileService {
	
	public String fileUp(MultipartFile file);
	public List<ImagesVO> filesUp(MultipartHttpServletRequest files);
	public void fileDelete(String i_up_image);

}
