package com.callor.iolist.controller;

import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.NamedValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.iolist.models.UserVO;
import com.callor.iolist.service.UserService;
import com.callor.iolist.utils.NamesValue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("BODY","USER_LOGIN");
		model.addAttribute("ERROR",error);
		return "layout";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username, String password,HttpSession httpSession) {
		log.debug("USERNAME {}, PASSWORD {}",username, password);
		
		UserVO userVO = userService.login(username, password);
		if(userVO != null) {
			httpSession.setAttribute(NamesValue.SESSION.USER, userVO);
		} else {
			httpSession.removeAttribute(NamesValue.SESSION.USER);
		}
		return "redirect:/";

	}

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		
		// 로그인에 사용된 USER 속성을 삭제하기
		httpSession.removeAttribute(NamesValue.SESSION.USER);
		
		// 모든 Session 정보를 삭제하기
		// httpSession.invalidate();

		return "redirect:/";
	}
	
}
