package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.CustomVO;
import com.callor.hello.persistance.CustomDao;

@Controller
@RequestMapping(value="/customer")
public class CustomorController {

	private final CustomDao customDao;
	public CustomorController(CustomDao customDao) {
		this.customDao = customDao;
	}
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		List<CustomVO> custList = customDao.selectAll();
		model.addAttribute("CUST_LIST",custList);
		return "custom/list";
	}
	
}
