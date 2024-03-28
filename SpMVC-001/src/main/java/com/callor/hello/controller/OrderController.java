package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.CustomVO;
import com.callor.hello.persistance.CustomDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/order")
public class OrderController {

	private final CustomDao customDao;
	public OrderController(CustomDao customDao) {
		this.customDao = customDao;
	}
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		
		List<CustomVO> custList = customDao.selectAll();
		log.debug(custList.toString());
		model.addAttribute("CUST_LIST",custList);
		return "order/list";

	}
	
	
}
