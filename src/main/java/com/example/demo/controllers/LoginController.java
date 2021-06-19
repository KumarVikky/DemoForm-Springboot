package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	//@CrossOrigin(origins = {"http://localhost:4200","https://demo-form-app.herokuapp.com"})
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@PostMapping(path="/user/login")
	public List<Student> loginUser(@RequestBody User user) throws Exception {
		String userName = user.getUserName();
		String userPassword = user.getPassword();
		List<Student> response = null;
		if(!userName.isBlank() && !userPassword.isBlank()) {
			if(service.isValidUserCredential(userName, userPassword)) {
				response = service.fetchAllStudents();
			}else {
				throw new Exception("Invalid User Credentials!");
			}
		}else {
			throw new Exception("Username or Password should not be blank.");
		}
		return response;
	}
}
