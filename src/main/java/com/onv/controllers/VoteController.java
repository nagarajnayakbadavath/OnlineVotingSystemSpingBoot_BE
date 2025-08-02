package com.onv.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onv.entities.Candidates;
import com.onv.entities.Elections;
import com.onv.entities.Users;
import com.onv.payload.AdminElectionRequest;
import com.onv.service.VoteService;

@RestController
public class VoteController {
   
	
	
	// Task: insert vote into vote table 
	
	
	// get voter_id from users table only voters can vote not admin special previlage is given to admins
	// candidate id to whom we are voting from candidate 
	// election_id from election table it should be active
	// insert iff voterid is not repeated
	
	
	@Autowired
	VoteService voteService;
	@PostMapping("/casteVote")
	public String getUserRole(@RequestBody AdminElectionRequest request) {
		
		Users user=request.getUser();
		Elections election=request.getElection();
		Candidates candidate=request.getCandidate();
		
		try {
			String list=voteService.findByEmailAndPassword(user.getEmail(), user.getPassword());
			
			if(list!=null && list.equalsIgnoreCase("voter")) {
				// after knowing as voter get election_id from election table by checking active or not
				   int status=voteService.isActive(election.getId());
				   int voter_id=user.getId();
				   
				   if(status==1) {
					   
					   // Here I am getting the candidates id's of that particular election 
					   
					   // run a loop of candidate to check the user choosen candidate is there or not if there then insert them in votes
					   
					   List<Integer> candidates=voteService.ListOfCandidates(election.getId());
					   int election_id=election.getId();
					   
					   for(int i=0;i<candidates.size();i++) {
						   if(candidates.get(i)==candidate.getId()) {
							   // insert now voter_id,candidate_id,election_id
							   
							   if (voteService.hasAlreadyVoted(voter_id, election_id) > 0) {
				                    return "You have already cast your vote.";
				                }

							   int ans=voteService.CasteVote(voter_id, election_id, candidate.getId());
							   if(ans>0) {
								   return "you have casted your vote";
							   }else {
								   return "you have not casted your vote";
							   }
						   }
					   }
					   return "Done";
				   }else {
					   return "election is not active anymore";
				   }
	
			}else {
				return "whether you are not found in db or you can be admin";
			}
		}catch(Exception e) {
			return "exception occured"+e.getMessage();
		}
		
	}
	
	
	
	
	 @GetMapping("/winner")
	    public ResponseEntity<Map<String, Object>> getElectionWinner() {
	        Integer winnerCandidateId = voteService.getElectionWinner();

	        Map<String, Object> response = new HashMap<>();
	        response.put("winnerCandidateId", winnerCandidateId);

	        return ResponseEntity.ok(response);
	    }	
}

