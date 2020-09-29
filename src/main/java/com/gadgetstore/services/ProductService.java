package com.gadgetstore.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gadgetstore.entity.Product;
import com.gadgetstore.repo.ProductRepo;

@Service("productService")
@Transactional
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	public Iterable<Product> findAll(){
		return productRepo.findAll();
	}
	
	public List<Product> findAll(int page){
		Pageable pageable = PageRequest.of(page, 10);
		return productRepo.findAll(pageable).getContent();
	}
	
	public List<Product> findAllByName(String name, int page) {
		Pageable pageable = PageRequest.of(page, 10);
		return productRepo.findAllByName(name, pageable);
	}
	
	public Optional<Product> findById(int id) {
		return productRepo.findById(id);
	}
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public boolean delete(int id) {
		productRepo.deleteById(id);
		return true;
	}
	
	public Product update(Product product) {
		return productRepo.save(product);
	}
}
