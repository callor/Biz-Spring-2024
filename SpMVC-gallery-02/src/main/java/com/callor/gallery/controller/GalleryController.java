package com.callor.gallery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	private final GalleryDao galleryDao;
	public GalleryController(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}

	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		List<GalleryVO> gList = galleryDao.selectAll();
		model.addAttribute("GALLERYS",gList);
		return "gallery/list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "gallery/input";
	}

	/*
	 * MultipartFile : form 의 input[type='file'] tag 에 담겨서 전달되는
	 * 파일을 수신하는 객체
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(GalleryVO galleryVO,
			@RequestParam("image_file")
			MultipartFile image_file) {
		
		log.debug("파일 업로드 {}", image_file.getOriginalFilename());
		
		return "gallery/input";
	}

	
}
