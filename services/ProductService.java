package com.app.services;

import com.app.entities.Products;

public interface ProductService 
{
	public Products findByCategory(String category);
	public void save(Products products);
	}
