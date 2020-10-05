package com.gadgetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gadgetstore.dto.ProductForm;
import com.gadgetstore.entity.Product;
import com.gadgetstore.services.BrandService;
import com.gadgetstore.services.CategoryService;
import com.gadgetstore.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("listOfProduct", productService.findAll());
		return "administrator/product/index";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("productForm", new ProductForm());
		model.addAttribute("listOfCategory", categoryService.findAll());
		model.addAttribute("listOfBrand", brandService.findAll());
		return "administrator/product/create";
	}
	
	@PostMapping("/save")
	public String save(ProductForm productForm, Model model) {
		Product product = new Product();
		product.setName(productForm.getName());
		product.setBrand(brandService.findById(productForm.getBrandId()).get());
		product.setCategory(categoryService.findById(productForm.getCategoryId()).get());
		product.setColor(productForm.getColor());
		product.setSlug(productForm.getSlug());
		product.setDescription(productForm.getDescription());
		product.setPrice(productForm.getPrice());
		product.setWeight(productForm.getWeight());
		productService.save(product);
		return "redirect:/product";
	}
	
	@GetMapping(value = "/edit/{id}/")
	public String edit(@PathVariable int id, Model model) {
		Product product = productService.findById(id).get();
		ProductForm form = new ProductForm();
		form.setId(product.getId());
		form.setName(product.getName());
		form.setBrandId(product.getBrand().getId());
		form.setCategoryId(product.getCategory().getId());
		form.setColor(product.getColor());
		form.setSlug(product.getSlug());
		form.setDescription(product.getDescription());
		form.setPrice(product.getPrice());
		form.setWeight(product.getWeight());
		model.addAttribute("productForm", form);
		model.addAttribute("listOfCategory", categoryService.findAll());
		model.addAttribute("listOfBrand", brandService.findAll());
		return "administrator/product/edit";
	}
	
	@PostMapping("/update")
	public String update(ProductForm productForm) {
		Product product = new Product();
		product.setId(productForm.getId());
		product.setName(productForm.getName());
		product.setBrand(brandService.findById(productForm.getBrandId()).get());
		product.setCategory(categoryService.findById(productForm.getCategoryId()).get());
		product.setColor(productForm.getColor());
		product.setSlug(productForm.getSlug());
		product.setDescription(productForm.getDescription());
		product.setPrice(productForm.getPrice());
		product.setWeight(productForm.getWeight());
		productService.update(product);
		return "redirect:/product";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String destroy(@PathVariable("id") int id) {
		productService.delete(id);
		return "redirect:/product";
	}
}
