package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring routing
 * Spring 에서는 Routing 을 Controller 라고 한다. 
 * Spring class 에 @Controller 를 부착하면 이 클래스가 Routing 을 수행하게 된다
 * Class 의 method 들이 각각의 Routing 이 되어 응답을 처리한다
 * 
 * 이때 각 method 에는 @RequestMapping 과 RequestMethod 를 부착하여
 * 각각의 Routing 경로와 응답 method 를 지정한다
 * 
 * @RequestMapping 을 Controller 에 부착하면
 * 대표 Routing 이 되고, 각 method 의 RequestMapping 과 함께 
 * 융합된 응답 Mapping 이 되고 Routing 을 수행한다
 * 
 * 이 클래스는 http://localhost:8080/hello/user/login 과 같은
 * 요청을 처리하는 Routing 이 된다.
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		/*
		 * Router 의 method 가 문자열을 return 하면
		 * WEB-INF/views 폴더에서 `문자열.jsp` 파일을 찾아서
		 * rendering 한 후 Response 를 한다.
		 * 
		 * 그런데 method 에서 null 을 return 하면
		 * 자신이 요청받은 Request Routing 주소를 문자열로 return 한것과
		 * 똑같이 작동한다
		 * 즉, return "user/login" 과 같다
		 */
		return null;
	}
		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username, String password, Model model) {
		// return "user/login";
		model.addAttribute("username",username);
		model.addAttribute("password",password);
		return null;
	}
	
}
