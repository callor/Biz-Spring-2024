package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.gallery.models.GalleryVO;
import com.callor.gallery.service.GalleryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	
	private final GalleryService galleryService;
	public GalleryController(GalleryService galleryService) {
		super();
		this.galleryService = galleryService;
	}

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "gallery/input";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(GalleryVO galleryVO) {
		log.debug(galleryVO.getG_image().length() + "");
		log.debug(galleryVO.getG_image().substring(0,100));
		log.debug("test");
		galleryService.createGallery(galleryVO);
		return "redirect:/";
	}

	
}
