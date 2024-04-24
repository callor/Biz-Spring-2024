package com.callor.gallery.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileUploadService {

	/**
	 * 파일객체 1개를 전달받아
	 * 해킹에 대비하여 파일 이름을 변형하고 
	 * 변형된 이름으로 서버의 폴더에 업로드(저장) 하고
	 * 변형된 이름을 return 하는 일을 수행
	 *  
	 * @param file
	 * @return
	 */
	public String fileUpload(MultipartFile file) ;
	
	public List<String> filsUpload(MultipartHttpServletRequest files)
	
	
	
	
	
	
}
