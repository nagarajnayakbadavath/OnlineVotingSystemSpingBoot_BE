package com.onv.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Votes")
public class Votes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="voter_id",referencedColumnName="id")
	private Users user;
	@ManyToOne
	@JoinColumn(name="candidate_id",referencedColumnName="id")
	private Candidates candidate;
	@ManyToOne
	@JoinColumn(name="election_id",referencedColumnName="id")
	private Elections election;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Candidates getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidates candidate) {
		this.candidate = candidate;
	}
	public Elections getElection() {
		return election;
	}
	public void setElection(Elections election) {
		this.election = election;
	}
	
}
