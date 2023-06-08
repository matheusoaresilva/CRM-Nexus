package com.matheus.crm.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.crm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findById(Long id);
	
	boolean existsByUsername(String username);
}