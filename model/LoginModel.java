package com.app.model;

public class LoginModel {

	private String email;
	private String password;
	private String role="USER";
	
	public String getRole()
	{
		return role;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
