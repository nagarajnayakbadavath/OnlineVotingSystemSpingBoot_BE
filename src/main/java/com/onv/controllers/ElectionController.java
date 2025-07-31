package com.onv.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onv.entities.Elections;
import com.onv.entities.Users;
import com.onv.payload.AdminElectionRequest;
import com.onv.service.ElectionService;

@RestController
public class ElectionController {

	
	@Autowired
	ElectionService electionService;
	@PostMapping("/adminLogin/insertElection")
	public String adminLogin(@RequestBody AdminElectionRequest request) {
		
		Users user=request.getUser();
		Elections election=request.getElection();
		
		String isAdmin=electionService.getUserRole(user.getEmail(),user.getPassword());
		
		if(isAdmin.equalsIgnoreCase("admin")) {
			electionService.insertElection(election);
			return "Election details are inserted";
		}else if(isAdmin.equalsIgnoreCase("voter")) {
			return "Your are a voter cannot insert the election details";
		}else {
			return "your are not found";
		}
	}
	
	
	
	// make the election active 
	
	
	
	
	
	
	
	// make the election inactive rather than deleting
	
}



