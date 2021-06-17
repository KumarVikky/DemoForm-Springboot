package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class RegistrationService {
	
	@Autowired 
	private UserRepository repo;
	
	public String saveUser(User user) {
		try {
			repo.save(user);
		}catch(Exception ex) {
			return "Failed -->"+ex.getMessage();
		}
		return "User Created Successfully!.";
	}
	
	public boolean emailExists(String email) {
		List<User> existingUsers = repo.findByEmail(email);
		if(existingUsers.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
}
