package com.callor.gallery.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.gallery.dao.GalleryDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	private final GalleryDao galleryDao;
	public HomeController(GalleryDao galleryDao) {
		super();
		this.galleryDao = galleryDao;
		this.galleryDao.create_table();
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "input" ;
	}
	
}
