package com.callor.book.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * 지금부터 이 Controller 는 REST(RESTful) 방식으로 동작한다 라는 선언
 * REST controller 는 ViewResolver 를 통하지 않고
 * "데이터"를 그대로 client(web)에 Direct 로 전달한다
 */
@RestController
@RequestMapping(value="/api")
public class NaverAPIController {
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public Map<String, String> add(String num1, String num2) {
		int sum = 0;
		try {
			sum = Integer.valueOf(num1) + Integer.valueOf(num2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("결과", sum + "");
		return result;
	}
}
