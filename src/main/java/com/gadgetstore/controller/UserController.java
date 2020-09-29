package com.gadgetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gadgetstore.dto.AddressForm;
import com.gadgetstore.dto.UserForm;
import com.gadgetstore.entity.Address;
import com.gadgetstore.entity.User;
import com.gadgetstore.services.AddressService;
import com.gadgetstore.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;
	
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
	public String update(UserForm userForm) {
		User user = new User();
		user.setId(userForm.getId());
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setBalance(userForm.getBalance());
		user.setPhoneNumber(userForm.getPhoneNumber());
		user.setProfileImage(userForm.getProfileImage());
		userService.update(user);
		return "redirect:/users";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String destroy(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/users";
	}
	
	@GetMapping(value = "/{id}/address")
	public String addressList(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.findById(id).get());
		model.addAttribute("listOfAddress", addressService.findAllByUserId(id));
		return "address/index";
	}
	
	@GetMapping("/{id}/address/create")
	public String addAddress(@PathVariable("id") int id, Model model) {
		AddressForm form = new AddressForm();
		form.setUserId(id);
		model.addAttribute("addressForm", form);
		return "address/create";
	}
	
	@PostMapping("/address/save")
	public String saveAddress(AddressForm addressForm, Model model) {
		Address address = new Address();
		address.setRecipientName(addressForm.getRecipientName());
		address.setAddress(addressForm.getAddress());
		address.setPostalCode(addressForm.getPostalCode());
		address.setCityId(addressForm.getCityId());
		address.setDefault(false);
		User user = userService.findById(addressForm.getUserId()).get();
		address.setUser(user);
		addressService.save(address);
		return "redirect:/users/address";
	}
	
	@GetMapping(value = "/address/edit/{id}/")
	public String editAddress(@PathVariable("id") int id, Model model) {
		Address address = addressService.findById(id).get();
		AddressForm form = new AddressForm();
		form.setId(address.getId());
		form.setRecipientName(address.getRecipientName());
		form.setAddress(address.getAddress());
		form.setCityId(address.getCityId());
		form.setPostalCode(address.getPostalCode());
		model.addAttribute("userForm", form);
		return "address/edit";
	}
	
	@PostMapping("/address/update")
	public String updateAddress(AddressForm addressForm, Model model) {
		Address address = new Address();
		
		addressService.update(address);
		return "redirect:/users/address";
	}
	
	@GetMapping(value = "/address/delete/{id}")
	public String destroyAddress(@PathVariable("id") int id) {
		addressService.delete(id);
		return "redirect:/users/address";
	}
}
