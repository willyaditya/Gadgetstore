package com.gadgetstore.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.gadgetstore.entity.Product;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer>{
	
	public List<Product> findAllByName(@Param("name") String name, Pageable pageable);
}
