package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entities.Customers;
import com.app.model.CustomerModel;
import com.app.repo.UserRepo;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private UserRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Override
	public Customers findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	@Override
	public String findEmailByEmail(String email) {
		return repo.findEmailByEmail(email);
	}


	@Override
	public void save(Customers customer) {
		repo.save(customer);
	}


	@Override
	public Customers userRegistartion(CustomerModel customerModel) {
		
		String existingEmail=customerModel.getEmail();
		if(existingEmail.equals(repo.findEmailByEmail(existingEmail)))
		{
			return null;
		}
		
		Customers customers=new Customers();
		customers.setAddress(customerModel.getAddress());
		customers.setCpassword(customerModel.getCpassword());
		customers.setCustomername(customerModel.getCustomername());
		customers.setEmail(customerModel.getEmail());
		customers.setMobile(customerModel.getMobile());
		customers.setPassword(encoder.encode(customerModel.getPassword()));
		customers.setRole("USER");
		
		repo.save(customers);
		return customers;
	}


}
