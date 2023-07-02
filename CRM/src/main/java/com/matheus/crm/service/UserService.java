package com.matheus.crm.service;

import com.matheus.crm.dto.AddressDTO;
import com.matheus.crm.dto.UserModelDTO;
import com.matheus.crm.entity.Address;
import com.matheus.crm.entity.UserModel;
import com.matheus.crm.service.exception.DatabaseException;
import com.matheus.crm.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matheus.crm.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserModel Create(UserModel model){
		return repository.save(model);
	}

	@Transactional(readOnly = true)
	public UserModelDTO findUserById(Long id) {
		Optional<UserModel> userOptional = repository.findById(id);
		UserModel entity = userOptional.orElseThrow(() -> new NotFoundException("ID: " + id + " not found!"));
		return new UserModelDTO(entity);
	}

	@Transactional
	public UserModelDTO updateUser(Long id, UserModelDTO u) {
		UserModel entity = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("User not found for id: " + id));

		entity.setRoles(entity.getRoles());

		entity.setName(u.getName());
		entity.setUsername(u.getUsername());
		entity.setPassword(u.getPassword());

		UserModel updatedUser = repository.save(entity);

		return new UserModelDTO(updatedUser);
	}

	@Transactional(readOnly = true)
	public List<UserModelDTO> findAll() {
		List<UserModel> list = repository.findAll();

		List<UserModelDTO> listDto = list.stream()
				.map(x -> new UserModelDTO(x)).collect(Collectors.toList());
		return listDto;
	}


	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("Id not found!");
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
