package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join( ) {
		
		// return "user/join";
		return null;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login( ) {
		
		// return "user/login";
		return null;
	}

	
}
