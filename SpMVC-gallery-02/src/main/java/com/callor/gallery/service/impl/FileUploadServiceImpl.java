package com.callor.gallery.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Override
	public String fileUpload(MultipartFile file) throws Exception {

		if(file.getOriginalFilename().isEmpty()) {
			return null;
		}
		
		String folder = "upload";
		File path = new File(folder);
		if(!path.exists()) {
			path.mkdirs();
		}
		File upLoadFile = new File(folder,file.getOriginalFilename());
		file.transferTo(upLoadFile);
		
		return null;
	}

	@Override
	public List<String> filsUpload(MultipartHttpServletRequest files) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
