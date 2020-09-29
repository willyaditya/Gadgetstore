package com.gadgetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gadgetstore.repo.ProductRepo;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	public String index() {
		return "products/index";
	}
}
