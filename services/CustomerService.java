package com.app.services;

import com.app.entities.Customers;
import com.app.model.CustomerModel;

import io.micrometer.common.lang.Nullable;

public interface CustomerService {

	@Nullable
	public Customers findByEmail(String email);

	public void save(Customers customer);

	public Customers userRegistartion(CustomerModel customerModel);
	public String findEmailByEmail(String email);

	
	
	
}
