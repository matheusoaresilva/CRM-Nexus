package com.matheus.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.crm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	boolean existsByUsername(String username);


	User findByUsername(String username);
}