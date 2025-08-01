package com.onv.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onv.entities.Users;
import com.onv.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	

	
	@PostMapping("/addUsers")
	public String insertUser(@RequestBody Users user) {
		return userService.insertUser(user);
	}
	
	
	
	// Getting the users 
	@GetMapping("/getUsers")
	public List<Users> getUsers(){
		try {
			List<Users> users=userService.getUsers();
//			for(Users user:users) {
//				System.out.println("The user name is "+user.getName()+"The user gmail is "+user.getEmail());
//			}
			return users;
		}catch(Exception e) {			
			System.out.println("an error occured"+e.getMessage());
			return new ArrayList<>();
		}
	}
	

	
	
	// In CRUD operations update will be done by save method only..So I will write a query to update the user by mailId
	@PatchMapping("/updateUser")
	public String updateUser(@RequestBody Users user) {
		int updatedRows=userService.updateUser(user.getName(),user.getEmail());
		
		// handle 
		
		if(updatedRows>0) {
			return "user is updated successfully";
		}else {
			return "user is not updated successfully";
		}
	}
	
	// deleteByEmail
	
	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestBody Users user) {
		int deletedRows=userService.deleteUser(user.getEmail());
		
		
		if(deletedRows>0) {
			return "deleted the user";
		}else {
			return "user is not deleted";
		}
	}
}
