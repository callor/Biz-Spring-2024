package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.ProductVO;
import com.callor.hello.persistance.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	private final ProductDao productDao;
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		List<ProductVO> proList = productDao.selectAll();
		model.addAttribute("PRODUCT_LIST",proList);
		return "product/list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return "product/input";
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(ProductVO productVO) {
		
		log.debug(productVO.toString());
		int result = productDao.insert(productVO);
		return "redirect:/product";
		
	}
	

}




