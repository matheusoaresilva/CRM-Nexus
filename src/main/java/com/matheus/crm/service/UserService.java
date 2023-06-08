package com.matheus.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.UserDTO;
import com.matheus.crm.entity.User;
import com.matheus.crm.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Transactional
	public UserDTO addUser(UserDTO user) {
		
		
		if (userRepository.existsByUsername(user.getUsername())) {
			throw new IllegalArgumentException("Username already exists!");
		}
		
		User entity = new User();
		entity.setName(user.getName());
		entity.setUsername(user.getUsername());
		entity.setPassword(passwordEncoder().encode(user.getPassword()));
		
		entity = userRepository.save(entity);
		return new UserDTO(entity);
		
	}
	
	
	
}
