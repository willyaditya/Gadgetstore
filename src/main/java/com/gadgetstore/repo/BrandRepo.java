package com.gadgetstore.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gadgetstore.entity.Brand;

public interface BrandRepo extends PagingAndSortingRepository<Brand, Integer> {

}
