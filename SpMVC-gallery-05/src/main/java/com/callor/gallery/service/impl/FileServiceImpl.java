package com.callor.gallery.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.models.ImagesVO;
import com.callor.gallery.service.FileService;
import com.callor.gallery.utils.Names;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImpl implements FileService{

	/*
	 * servlet-context.xml 에 bean 으로 선언한 문자열 변수 값을
	 * 자동으로 import( DI )
	 */
	private final String uploadDir;
	public FileServiceImpl(String uploadDir) {
		this.uploadDir = uploadDir;
		log.debug("업로드 폴더 {}", uploadDir);
	}

	@Override
	public String fileUp(MultipartFile file) {

		String originName = file.getOriginalFilename();
		if(originName.isEmpty()) return null;
		
		// 문자열 uploadDir 값을 File 객체로 생성(변환)
		File path = new File(uploadDir);
		// 폴더를 검사하여 없으면 새로 생성하라
		if( !path.exists()) {
			path.mkdirs();
		}
		String uuid = UUID.randomUUID().toString();
		String upLoadFileName = String.format("%s-%s", uuid,originName);
		
		// 파일을 업로드 하기 위하여 File 객체로 생성하기
		File uploadFile = new File(uploadDir, upLoadFileName);
		
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return upLoadFileName;
	}

	@Override
	public List<ImagesVO> filesUp(MultipartHttpServletRequest files) {

		List<MultipartFile> fileList = files.getFiles(Names.FILES);
		List<ImagesVO> images = new ArrayList<>();
		int index = 0;
		for(MultipartFile file : fileList) {
			String resultFileName = this.fileUp(file);
			ImagesVO vo = ImagesVO.builder()
					.i_id(UUID.randomUUID().toString())
					.i_up_image(resultFileName)
					.i_seq(index++)
					.i_origin_image(file.getOriginalFilename())
					.build();
			images.add(vo);
		}
		return images;
	}

	@Override
	public void fileDelete(String i_up_image) {
		File deleteFile = new File(uploadDir, i_up_image);
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
	}
}
