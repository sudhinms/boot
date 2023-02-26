package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Products;

public interface ProductRepo extends JpaRepository<Products, Long>
{
	public Products findByCategory(String category);
}
