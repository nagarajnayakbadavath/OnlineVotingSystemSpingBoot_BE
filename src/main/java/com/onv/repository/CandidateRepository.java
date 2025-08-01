package com.onv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onv.entities.Candidates;

@Repository
public interface CandidateRepository extends JpaRepository<Candidates, Integer>{

	@Query("select u.role from Users as u where u.email=:email and u.password=:password")
	List<String> findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
	
	
	@Query("select e.id from Elections as e where id=:eid")
	Integer checkElectionId(@Param("eid") int eid);
	
	
}
