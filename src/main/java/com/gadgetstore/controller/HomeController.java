package com.gadgetstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String index() {
		return "dashboard/index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
