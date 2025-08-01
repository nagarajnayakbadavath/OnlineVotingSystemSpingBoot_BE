package com.onv.payload;

import com.onv.entities.Candidates;
import com.onv.entities.Elections;
import com.onv.entities.Users;

public class AdminElectionRequest {

	private Users user;
	private Elections election;
	private Candidates candidate;
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Elections getElection() {
		return election;
	}
	public void setElection(Elections election) {
		this.election = election;
	}
	public Candidates getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidates candidate) {
		this.candidate = candidate;
	}
	
}
