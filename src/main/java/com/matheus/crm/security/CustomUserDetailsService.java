package com.matheus.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.matheus.crm.entity.User;
import com.matheus.crm.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		return (UserDetails) userRepository.findByLogin(username);

//		User user = userRepository.findByUsernameFetchRoles(username);
//
//		if (user != null) {
//			throw new IllegalArgumentException("Username does exists!");
//		}
//
//		return UserPrincipal.create(user);
	}
	

}
