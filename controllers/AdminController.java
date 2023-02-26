package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.entities.Products;
import com.app.repo.ProductRepo;

@Controller
public class AdminController 
{
	@Autowired
	@Qualifier("productRepo")
	private ProductRepo productRepo;
	private String productAddStatus;

	@RequestMapping("/admin/login")
	public String adLogin()
	{
		return "admin/login.html";
	}
	
	@RequestMapping("/admin/register")
	public String adRegister()
	{
		return "admin/register.html";
	}
	
	@RequestMapping("/admin/index")
	public String adIndex()
	{
		return "admin/index.html";
	}
	
	@RequestMapping("/admin/accounts")
	public String adAccounts()
	{
		return "admin/accounts.html";
	}
	
	@RequestMapping("/admin/add-product")
	public String addProducts(Model model)
	{
		model.addAttribute("product", new Products());
		return "admin/add-product.html";
	}
	
	@RequestMapping(value="/admin/add-product/save",method = RequestMethod.POST)
	public String submitProduct(@ModelAttribute("product") Products product, Model model
			)throws Exception
	{
		try{
			productRepo.save(product);
			this.productAddStatus="Product successfully added";
		}
		catch (Exception e) {
			this.productAddStatus="Product not added";
		}
		model.addAttribute("productAddStatus",this.productAddStatus);
		return "redirect:/admin/add-product";
	}
	
	@RequestMapping("/admin/edit-product")
	public String editProduct()
	{
		return "admin/edit-product.html";
	}
	
	@RequestMapping("/admin/products")
	public String listProducts()
	{
		return "admin/products.html";
	}
	
}
