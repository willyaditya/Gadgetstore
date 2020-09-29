package com.gadgetstore.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gadgetstore.entity.User;

public interface UserRepo extends PagingAndSortingRepository<User, Integer>{
	
	public User findByEmail(String email);
	
}
