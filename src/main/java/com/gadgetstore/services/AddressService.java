package com.gadgetstore.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gadgetstore.entity.Address;
import com.gadgetstore.repo.AddressRepo;

@Service
@Transactional
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;
	
	public Iterable<Address> findAllByUserId(int userId) {
		return addressRepo.findAllByUserId(userId);
	}
	
	public Optional<Address> findById(int id) {
		return addressRepo.findById(id);
	}
	
	public Address save(Address address) {
		return addressRepo.save(address);
	}
	
	public boolean delete(int id) {
		addressRepo.deleteById(id);
		return true;
	}
}
