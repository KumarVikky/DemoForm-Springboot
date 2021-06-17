package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
		
	public List<User> findByEmail(String email);
	public User findByUserNameAndPassword(String userName, String password);

}
