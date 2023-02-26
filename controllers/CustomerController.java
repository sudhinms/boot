package com.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entities.Customers;
import com.app.model.CustomerModel;
import com.app.repo.UserRepo;
import com.app.services.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController 
{
	@Autowired
	private UserRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private CustomerService customerService;
	
	
	private String message;
	private String loginStatusMessage;
	
	
	@RequestMapping("/customer/home/about")
	public String about()
	{
		return "about.html";
	}
	
	@RequestMapping("/customer/home/blog")
	public String blog()
	{
		return "blog.html";
	}
	
	@RequestMapping("/home/blog-details")
	public String blogDetails()
	{
		return "blog-details.html";
	}
	
	@RequestMapping("/customer/home/checkout")
	public String checkout()
	{
		return "checkout.html";
	}
	
	@RequestMapping("/customer/home/contact")
	public String contact()
	{
		return "contact.html";
	}
	
	@RequestMapping("/customer/home/index")
	public String userIndex(/*HttpSession session,Model model*/)
	{
//		String userName=(String) session.getAttribute("userName");
//		model.addAttribute("userName", userName);
		return "index.html";
	}
	
	@RequestMapping("/customer/login")
	public String userLogin(Model model)
	{
		model.addAttribute("login", new CustomerModel());
		return "login.html";
	}
	
	@RequestMapping(value="/customer/login/submit",method = RequestMethod.POST)
	public String loginSubmission(@RequestParam("email") String email,@RequestParam("password") String password,
			Model model,HttpSession session)
	{
		Customers loginCustomer=repo.findByEmail(email);
		if((loginCustomer.getEmail()).equals(email) && (loginCustomer.getPassword()).equals(password) )
		{
			String userName=loginCustomer.getCustomername();
			System.out.println("login success");
			session.setAttribute("userName",userName);
			return "index.html";
		}
		this.loginStatusMessage="login failed";
		model.addAttribute("loginStatusMessage", this.loginStatusMessage);
		return "index.html";
	}

	@RequestMapping("/customer/home/shop")
	public String shop()
	{
		return "shop.html";
	}
	
	@RequestMapping("/customer/home/shop-details")
	public String shopDetails()
	{
		return "shop-details.html";
	}
	
	@RequestMapping("/customer/home/shopping-cart")
	public String shoppingCart()
	{
		return "shopping-cart.html";
	}
	
	@RequestMapping("/customer/register")
	public String userRegistartion(@ModelAttribute CustomerModel customerModel)
	{
		return "Userregister.html";
	}
	
	@RequestMapping(value = "/customer/register/save" ,method=RequestMethod.POST)
	public String saveCustomer(@RequestBody CustomerModel customerModel,Model model)
	{		
		if(customerModel.getPassword() != customerModel.getCpassword()) {
			this.message="password not match try again";
		}
		Customers customers=customerService.userRegistartion(customerModel);
		if(customers==null) {
			this.message="user already exist try login";
			}
		else {this.message="registraion successfull";}
		model.addAttribute("message", this.message);
		return "redirect:/customer/login";
	}
}
	

	








