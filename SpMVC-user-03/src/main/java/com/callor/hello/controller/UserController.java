package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.models.UserVO;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return null;
	}

	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug("회원가입 정보 {}, {}",userVO.getUsername(), userVO.getPassword());
		
		UserVO ret = userService.createUser(userVO);
		return null;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck/{username}")
	public String idcheck(@PathVariable("username") String username) {
		UserVO userVO = userService.findById(username);
		//  username 사용자이름이 가입되지 않았다
		if(userVO == null) return "OK";
		return null;
	}
	
}
