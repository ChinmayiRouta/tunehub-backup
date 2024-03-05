package com.kodnest.tunehub.service;

import com.kodnest.tunehub.entity.User;

public interface UserService  {
	public String addUser(User user); 
	public boolean emialExists(String email);
	public boolean validateuser(String email, String password);
	public  String getRole(String email);
	
	public User getUser(String email);
	public void updateUser(User user);

}
