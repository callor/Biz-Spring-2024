package com.callor.hello.controller;

import java.io.PipedOutputStream;
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
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "custom/input";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public  String insert(CustomVO vo,Model model) {
		try {
			int result = customDao.insert(vo);
			if(result > 0 ) {
				return "redirect:/customer";
			} else {
				model.addAttribute("MSG","INSERT ERROR");
				return "custom/input";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("MSG","INSERT SQL ERROR");
			return "custom/input";
		}
	}
	
}
