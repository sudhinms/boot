package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.entities.Products;
import com.app.repo.ProductRepo;

@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepo repo;

	@Override
	public Products findByCategory(String category) {
		return repo.findByCategory(category);
	}

	@Override
	public void save(Products products){
		repo.save(products);
	}

	
}
