package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bbs")
public class BBsController {

	@RequestMapping(value={"/",""},  method=RequestMethod.GET)
	public String home() {
		return null ;
	}
	@RequestMapping(value="/free",method=RequestMethod.GET)
	public String free() {
		return null;
	}
	@RequestMapping(value="/free/write",method=RequestMethod.GET)
	public String write() {
		return null;
	}
}
