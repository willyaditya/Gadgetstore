package com.gadgetstore.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gadgetstore.entity.User;
import com.gadgetstore.repo.UserRepo;

@Service("userService")
@Transactional
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public Iterable<User> findAll() {
		return userRepo.findAll();
	}
	
	public List<User> findAll(int page) {
		Pageable pageable = PageRequest.of(page, 10);
		return userRepo.findAll(pageable).getContent();
	}
	
	public User findByEmail(String email) {
		return userRepo.findAllByEmail(email);
	}
	
	public Optional<User> findById(int id) {
		return userRepo.findById(id);
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}
	
	public boolean delete(int id) {
		userRepo.deleteById(id);
		return true;
	}
	
	public User update(User user) {
		return userRepo.save(user);
	}
	
	public void updateUser(User user) {
//	    User userTemp = userRepo.findById(user.getId()).get();
//	    userTemp.setName(user.getName());
//	    userTemp.setEmail(user.getEmail());
//	    userTemp.setBalance(user.getBalance());
//	    userTemp.setPhoneNumber(user.getPhoneNumber());
//	    userTemp.setProfileImage(user.getProfileImage());
	    userRepo.save(user);
	}
}
