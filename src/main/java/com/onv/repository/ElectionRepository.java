package com.onv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onv.entities.Elections;


@Repository
public interface ElectionRepository extends JpaRepository<Elections, Integer>{

	
	@Query("select u.role from Users as u where u.email=:email and u.password=:password")
	List<String> findByEmailAndPassword(@Param("email") String email,@Param("password") String password);
	
}
