package com.onv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onv.service.UserService;

@RestController
public class HomeController {

	
	@Autowired
	UserService userService;
	@RequestMapping("/")
	public String HomeGreet() {
		return userService.HomeGreet();
	}
}
