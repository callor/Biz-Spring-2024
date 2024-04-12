package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 403 오류가 발생할경우 /views/auth/denied.jsp 페이지를 보여주는
 * Forwarding URL
 */
@Controller
@RequestMapping(value="/auth")
public class AuthController {
	
	@RequestMapping(value="/denied",method=RequestMethod.GET)
	public String denied() {
		return null;
	}

}
