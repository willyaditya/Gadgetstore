package com.gadgetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gadgetstore.dto.BrandForm;
import com.gadgetstore.entity.Brand;
import com.gadgetstore.services.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("listOfBrand", brandService.findAll());
		model.addAttribute("brandForm", new BrandForm());
		return "administrator/brand/index";
	}
	
	/*
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("brandForm", new BrandForm());
		return "brand/create";
	}
	*/
	
	@PostMapping("/save")
	public String save(BrandForm brandForm, Model model) {
		Brand brand = new Brand();
		brand.setName(brandForm.getName());
		brandService.save(brand);
		return "redirect:/brand";
	}
	
	@GetMapping(value = "/edit/{id}/")
	public String edit(@PathVariable int id, Model model) {
		Brand brand = brandService.findById(id).get();
		BrandForm form = new BrandForm();
		form.setId(brand.getId());
		form.setName(brand.getName());
		model.addAttribute("brandForm", form);
		return "administrator/brand/edit";
	}
	
	@PostMapping("/update")
	public String update(BrandForm brandForm) {
		Brand brand = new Brand();
		brand.setId(brandForm.getId());
		brand.setName(brandForm.getName());
		brandService.update(brand);
		return "redirect:/brand";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String destroy() {
		return "redirect:/";
	}
}
