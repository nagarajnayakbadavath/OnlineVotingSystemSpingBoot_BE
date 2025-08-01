package com.onv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onv.entities.Candidates;
import com.onv.repository.CandidateRepository;

@Service
public class CandidateService {

	
	@Autowired
	CandidateRepository candidateRepository;
	public String checkAdmin(String email,String password) {
		List<String> role=candidateRepository.findByEmailAndPassword(email,password);
		if(!role.isEmpty()) {
			return role.get(0);
		}else {
			return null;
		}
	}
	
	public Integer checkId(int eid) {
		return candidateRepository.checkElectionId(eid);
	}
	
	public void insertCandidate(Candidates candidate){
		candidateRepository.save(candidate);
	}
	
	
}
