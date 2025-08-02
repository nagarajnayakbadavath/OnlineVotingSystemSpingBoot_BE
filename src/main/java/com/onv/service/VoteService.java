package com.onv.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onv.repository.VoteRepository;

@Service
public class VoteService {
	
	@Autowired
	VoteRepository voteRepository;
	
	public String findByEmailAndPassword(String email,String Password) {
		List<String> role=voteRepository.findByEmailAndPassword(email, Password);
		if(!role.isEmpty()) {
			return role.get(0);
		}else {
			return null;
		}
	}
	
	
	public int isActive(int id) {
		List<String> status=voteRepository.checkElectionStatus(id);
		
		return Integer.parseInt(status.get(0));
	}
	
	
	
	public List<Integer> ListOfCandidates(int id){
		
		 return voteRepository.getCandidates(id);
		
	}
	
	public int CasteVote(int voter_id,int election_id,int candidate_id) {
		return voteRepository.insert(voter_id, candidate_id, election_id);
	}
	

	
	public int hasAlreadyVoted(int voterId, int electionId) {
	    return voteRepository.hasAlreadyVoted(voterId, electionId);
	}

	
	  public Integer getElectionWinner() {
	        return voteRepository.getWinner();
	    }

	

	
	
}




