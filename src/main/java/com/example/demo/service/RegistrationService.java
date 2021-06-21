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
	
	public void saveUser(User user) {
		repo.save(user);
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
