package com.gadgetstore.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gadgetstore.entity.Category;
import com.gadgetstore.repo.CategoryRepo;

@Service("categoryService")
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public Iterable<Category> findAll() {
		return categoryRepo.findAll();
	}
	
	public Optional<Category> findById(int id) {
		return categoryRepo.findById(id);
	}
	
	public Category save(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category update(Category category) {
		return categoryRepo.save(category);
	}
	
	public boolean delete(int id) {
		categoryRepo.deleteById(id);
		return true;
	}
}
