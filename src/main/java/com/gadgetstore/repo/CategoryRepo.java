package com.gadgetstore.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gadgetstore.entity.Category;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Integer> {
	
}
