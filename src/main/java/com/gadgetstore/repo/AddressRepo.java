package com.gadgetstore.repo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gadgetstore.entity.Address;

public interface AddressRepo extends PagingAndSortingRepository<Address, Integer> {

	public List<Address> findAllByUserId(int userId);
	
	
}
