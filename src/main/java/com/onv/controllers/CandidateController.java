package com.onv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onv.entities.Candidates;
import com.onv.entities.Elections;
import com.onv.entities.Users;
import com.onv.payload.AdminElectionRequest;
import com.onv.service.CandidateService;

@RestController
public class CandidateController {

	@Autowired
	CandidateService candidateService;
	@PostMapping("insertCandidate")
	public String insertCandidate(@RequestBody  AdminElectionRequest request) { /* Here in production side use jwt here I am writing the repeated code for checking admin*/
		
		Users user=request.getUser();
		Elections election=request.getElection();
		Candidates candidate=request.getCandidate();
		
		try {
		String isAdmin=candidateService.checkAdmin(user.getEmail(),user.getPassword());
		if(isAdmin.equalsIgnoreCase("admin")) {
			
			Integer row=candidateService.checkId(election.getId());
			
			if(row!=null) {
				candidate.setElection(election);
				candidateService.insertCandidate(candidate);
			}else {
				return "eid it not there with you first get election id and then participate as a candidate";
			}
			
			return "candidate is added for competition";
			
		}else {
			return "use may be a voter or else not found try again!!";
		}
		
		}catch(Exception e) {
			return "error ocured"+e.getMessage();
		}
	}
}
