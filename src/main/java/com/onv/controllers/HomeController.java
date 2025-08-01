package com.onv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onv.service.UserService;

@RestController
public class HomeController {

	
	@Autowired
	UserService userService;
	@GetMapping("/")
	public String HomeGreet() {
		return userService.HomeGreet();
	}
}
