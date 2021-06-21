package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	//@CrossOrigin(origins = {"http://localhost:4200","https://demo-form-app.herokuapp.com"})
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@PostMapping(path="/user/login")
	public ResponseEntity<Object> loginUser(@RequestBody User user){
		try {
			String userName = user.getUserName();
			String userPassword = user.getPassword();
			if(!userName.isBlank() && !userPassword.isBlank()) {
				if(service.isValidUserCredential(userName, userPassword)) {
					return ResponseHandler.generateResponse("Success", HttpStatus.OK, service.fetchAllStudents());
				}else {
					return ResponseHandler.generateResponse("Invalid User Credentials!", HttpStatus.CONFLICT, null);
				}
			}else {
				return ResponseHandler.generateResponse("Username or Password should not be blank.", HttpStatus.BAD_REQUEST, null);
			}
		}catch(Exception ex) {
			return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
}
