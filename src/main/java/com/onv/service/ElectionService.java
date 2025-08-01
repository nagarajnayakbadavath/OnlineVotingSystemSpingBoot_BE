package com.onv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onv.entities.Elections;
import com.onv.repository.ElectionRepository;

@Service
public class ElectionService {

	@Autowired
	ElectionRepository electionRepository;
	public String getUserRole(String email,String password) {
		List<String> role=electionRepository.findByEmailAndPassword(email,password);
		if(!role.isEmpty()) {
			return role.get(0);
		}else {
			return null;
		}
	}
	
	
	
	
	public String insertElection(Elections election) {
		try {
			electionRepository.save(election);
			return "true";
			
		}catch(Exception e) {
			return "error occured"+e.getMessage();
			
		}
		
	}
	
	public String makeElectionActive(int election_id){
		try {
			electionRepository.makeElectionActive(election_id);
			return "Election is activated";
			
		}catch(Exception e) {
			return "error occured"+e.getMessage();
		}
	}
	
	public String makeElectionInActive(int election_id){
		try {
			electionRepository.makeElectionInActive(election_id);
			return "Election is Inactivated";
			
		}catch(Exception e) {
			return "error occured"+e.getMessage();
		}
	}
}


