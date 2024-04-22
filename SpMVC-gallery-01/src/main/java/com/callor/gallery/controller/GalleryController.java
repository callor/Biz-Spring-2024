package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "gallery/input";
	}

}
