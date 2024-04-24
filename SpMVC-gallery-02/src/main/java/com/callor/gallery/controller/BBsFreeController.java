package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bbs/free")
public class BBsFreeController {
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String home() {
		return "bbs/free/list";
	}
}
