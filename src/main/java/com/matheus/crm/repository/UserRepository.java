package com.matheus.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matheus.crm.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


	boolean existsByUsername(String username);


	User findByUsername(String username);
}