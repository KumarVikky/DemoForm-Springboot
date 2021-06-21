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
import com.example.demo.service.RegistrationService;

@RestController
public class RegistrationController {
		
	@Autowired
	private RegistrationService service;
	
	//@CrossOrigin(origins = {"http://localhost:4200","https://demo-form-app.herokuapp.com"})
	@CrossOrigin(origins = "*",allowedHeaders = "*")
	@PostMapping(path="/user/register", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> registerUser(@RequestBody User user){
		try {
			System.out.println("output:::::::"+user);
			String tempEmailId = user.getEmail();
			if(!tempEmailId.isBlank() && !tempEmailId.isEmpty()) {	
				if(service.emailExists(tempEmailId)) {
					return ResponseHandler.generateResponse("Email with '"+tempEmailId+"' already exists.", HttpStatus.CONFLICT, null);
				}else {
					service.saveUser(user);
					return ResponseHandler.generateResponse("Successully registered with this '" + tempEmailId +"' Email", HttpStatus.OK, null);
				}
			}else {
				return ResponseHandler.generateResponse("Email should not be Null", HttpStatus.BAD_REQUEST, null);
			}
		}catch(Exception ex) {
			return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

}
