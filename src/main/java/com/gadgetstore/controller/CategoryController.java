package com.gadgetstore.controller;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gadgetstore.dto.CategoryForm;
import com.gadgetstore.entity.Category;
import com.gadgetstore.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("listOfCategory", categoryService.findAll());
		return "category/index";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("categoryForm", new CategoryForm());
		return "category/create";
	}
	
	@PostMapping("/save")
	public String save(CategoryForm categoryForm, Model model) {
		Category category = new Category();
		category.setName(categoryForm.getName());
		category.setSlug(categoryForm.getSlug());
		categoryService.save(category);
		return "redirect:/category";
	}
	
	@GetMapping(value = "/edit/{id}/")
	public String edit(@PathVariable int id, Model model) {
		Category category = categoryService.findById(id).get();
		CategoryForm form = new CategoryForm();
		form.setId(category.getId());
		form.setName(category.getName());
		form.setSlug(category.getSlug());
		model.addAttribute("categoryForm", form);
		return "category/edit";
	}
	
	@PostMapping("/update")
	public String update(CategoryForm categoryForm) {
		Category category = new Category();
		category.setId(categoryForm.getId());
		category.setName(categoryForm.getName());
		category.setSlug(categoryForm.getSlug());
		categoryService.update(category);
		return "redirect:/category";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String destroy() {
		return "redirect:/";
	}
}
