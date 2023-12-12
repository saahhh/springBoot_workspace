package com.kh.springdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.User;

public interface UserRepository extends JpaRepository <User, Long>{
	
	Optional<User> findByusername(String username);
	
}
