package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;

@RestController
public class RegistrationController {
		
	@Autowired
	private RegistrationService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/user/register", produces = "application/json")
	public String registerUser(@RequestBody User user) throws Exception {
		System.out.println("output:::::::"+user);
		String response = null;
		String tempEmailId = user.getEmail();
		if(!tempEmailId.isBlank() && !tempEmailId.isEmpty()) {	
			if(service.emailExists(tempEmailId)) {
				throw new Exception("Email with "+tempEmailId+" already exists.");
			}else {
				response = service.saveUser(user);
			}
		}else {
			throw new Exception("Email should not be Null.");
		}
		return response;
	}

}
