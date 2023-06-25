package com.matheus.crm.service;

import com.matheus.crm.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.matheus.crm.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserModel Create(UserModel model){
		return repository.save(model);
	}

	public Optional<UserModel> getUserById(Long id) {
		return repository.findById(id);
	}

	public UserModel updateUser(UserModel User){
		return repository.save(User);
	}

	public List<UserModel> findAll(){
		return repository.findAll();
	}

	public void deleteById(Long id){
		repository.deleteById(id);
	}
}
