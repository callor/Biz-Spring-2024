package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.gallery.models.UserVO;
import com.callor.gallery.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return null;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug("회원가입 {}", userVO.toString());
		int ret = userService.create_user(userVO);
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return null;
	}

}
