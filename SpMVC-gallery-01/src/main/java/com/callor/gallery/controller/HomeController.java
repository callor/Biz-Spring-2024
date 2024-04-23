package com.callor.gallery.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.gallery.dao.GalleryDao;
import com.callor.gallery.models.GalleryVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final GalleryDao galleryDao;
	public HomeController(GalleryDao galleryDao) {
		super();
		this.galleryDao = galleryDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<GalleryVO> gList = galleryDao.selectAll();
		model.addAttribute("GALLERYS",gList);
		return "home";
	}
	
	@RequestMapping(value="/bbs",  method=RequestMethod.GET)
	public String home() {
		return null ;
	}

	
}
