package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bbs/free")
public class BBsFreeController {
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String free() {
		return null;
	}
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write() {
		return null;
	}
	@RequestMapping(value="/like",method=RequestMethod.GET)
	public String like() {
		return null;
	}
	
}
