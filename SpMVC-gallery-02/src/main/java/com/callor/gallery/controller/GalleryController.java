package com.callor.gallery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;

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
	
}
