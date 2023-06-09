package com.matheus.crm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.entity.User;
import com.matheus.crm.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	public User execute(User user) {
		
		User existsUser = userRepository.findByUsername(user.getUsername());
		
		if (existsUser != null) {
			throw new IllegalArgumentException("O nome de usuário já está em uso.");
		}
		
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		
		User createdUser = userRepository.save(user);
		
		return createdUser;
		
//		if (userRepository.existsByUsername(user.getUsername())) {
//	        throw new IllegalArgumentException("O nome de usuário já está em uso.");
//	    }
//		
//		User entity = new User();
//		
//		
//		entity.setName(user.getName());
//		entity.setUsername(user.getUsername());
//		entity.setPassword(passwordEncoder().encode(user.getPassword()));
//		entity.setRoles(user.getRoles());
//		
//		entity = userRepository.save(entity);
//		return new UserDTO(entity);
		
	}
	
//	@Transactional(readOnly = true)
//	public List<UserDTO> findAllUsers() {
//		List<User> list = (List<User>) userRepository.findAll();
//
//		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
//		return listDto;
//	}
	
	
	
}
