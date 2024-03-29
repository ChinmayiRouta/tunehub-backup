package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepository;
import com.kodnest.tunehub.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	public String addUser(User user) {
		userRepository.save(user);
		return "User added successfully";
	}
	//logic to check the duplicate entries
	public boolean emialExists(String email) {
		if (userRepository.findByEmail(email)!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean validateuser(String email, String password) {
		User user=userRepository.findByEmail(email);
		String dbpw=user.getPassword();
		if(password.equals(dbpw)) {
		return true;
		}else {
			return false;
		}
	}
	
	public  String getRole(String email) {
		User user=userRepository.findByEmail(email);
		return user.getRole();
	}
	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email) ;
	}
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	

}
