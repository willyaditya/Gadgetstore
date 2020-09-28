package com.gadgetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gadgetstore.dto.UserForm;
import com.gadgetstore.entity.User;
import com.gadgetstore.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("listOfUsers", userService.findAll());
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "create";
	}
	
	@PostMapping("/save")
	public String save(UserForm userForm, Model model) {
		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setBalance(userForm.getBalance());
		user.setPhoneNumber(userForm.getPhoneNumber());
		user.setProfileImage(userForm.getProfileImage());
		userService.save(user);
		return "redirect:/users";
	}
	
	@GetMapping(value = "/edit/{id}/")
	public String edit(@PathVariable("id") int id, Model model) {
		User user = userService.findById(id).get();
		UserForm form = new UserForm();
		form.setId(user.getId());
		form.setName(user.getName());
		form.setEmail(user.getEmail());
		form.setBalance(user.getBalance());
		form.setPhoneNumber(user.getPhoneNumber());
		form.setProfileImage(user.getProfileImage());
		model.addAttribute("userForm", form);
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(UserForm userForm, Model model) {
		User user = new User();
		user.setId(userForm.getId());
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setBalance(userForm.getBalance());
		user.setPhoneNumber(userForm.getPhoneNumber());
		user.setProfileImage(userForm.getProfileImage());
		userService.updateUser(user);
		return "redirect:/users";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String destroy(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/users";
	}
}
