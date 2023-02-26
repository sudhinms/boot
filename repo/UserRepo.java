package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customers;


public interface UserRepo extends JpaRepository<Customers, Long>
{
	public Customers findByEmail(String email);
	public String findEmailByEmail(String email);

}
