package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.models.ProductVO;
import com.callor.hello.persistance.ProductDao;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	private final ProductDao productDao;
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String home(Model model) {
		List<ProductVO> proVO = productDao.selectAll();
		model.addAttribute("PRODUCT_LIST",proVO);
		return "product/list";
	}
	

}
