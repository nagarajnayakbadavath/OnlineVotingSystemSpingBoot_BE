package com.onv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onv.entities.Users;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
	
	@Modifying
	@Transactional
	@Query("update Users as u set u.name=:name where u.email=:email")
	int updateByEmail(@Param("name") String name,@Param("email") String email);
	
	@Modifying
	@Transactional
	@Query("delete from Users where email=:email")
	int deleteByEmail(@Param("email") String email);
	
	
}
