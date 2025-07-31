package com.onv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onv.entities.Users;
import com.onv.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String insertUser(Users user) {
		
		userRepository.save(user);
		return "user added!!!";
	}
	
	public List<Users> getUsers(){
		return userRepository.findAll();
	}
	
	public int updateUser(String name,String email) {
		int value=userRepository.updateByEmail(name,email);
		
		
		return value;
	}
	
	public int deleteUser(String email) {
		int value=userRepository.deleteByEmail(email);
		return value;
	}
	
	
	public String HomeGreet() {
		return "Hello World";
	}
}
