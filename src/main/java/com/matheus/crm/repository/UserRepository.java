package com.matheus.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matheus.crm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByLogin(String login);

	boolean existsByUsername(String username);
	
	@Query("SELECT u from User u JOIN FETCH u.roles where u.username =: username")
	User findByUsernameFetchRoles(@Param("username") String username);

	User findByUsername(String username);
}