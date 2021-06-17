package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Student;
import com.example.demo.model.User;

@Service
public class LoginService {
	
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private UserRepository userRepo;
	
	public boolean isValidUserCredential(String userName, String userPassword) {
		User obj = userRepo.findByUserNameAndPassword(userName, userPassword);
		if(obj == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public List<Student> fetchAllStudents(){
		return studentRepo.findAll();
	}
}
