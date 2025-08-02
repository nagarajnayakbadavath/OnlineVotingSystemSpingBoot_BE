package com.onv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onv.entities.Votes;

import jakarta.transaction.Transactional;

@Repository
public interface VoteRepository extends JpaRepository<Votes, Integer>{

	@Query("select u.role from Users as u where u.email=:email and u.password=:password")
	List<String> findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
	
	
	@Query("select e.isActive from Elections as e where e.id=:id")
	List<String> checkElectionStatus(@Param("id") int id);
	

	
	@Query("SELECT c.id FROM Candidates c WHERE c.election.id= :id")
	List<Integer> getCandidates(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO Votes (voter_id, candidate_id, election_id) VALUES (:voter_id, :candidate_id, :election_id)", nativeQuery = true)
	int insert(@Param("voter_id") int voter_id, @Param("candidate_id") int candidate_id, @Param("election_id") int election_id);

	
	@Query("SELECT COUNT(v) FROM Votes v WHERE v.user.id = :voterId AND v.election.id = :electionId")
	int hasAlreadyVoted(@Param("voterId") int voterId, @Param("electionId") int electionId);
	
	
	@Query(value = "SELECT candidate_id FROM votes GROUP BY candidate_id ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
	Integer getWinner();



}
