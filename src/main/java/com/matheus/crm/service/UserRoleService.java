//package com.matheus.crm.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.matheus.crm.dto.UserRoleDTO;
//import com.matheus.crm.entity.Role;
//import com.matheus.crm.entity.UserModel;
//import com.matheus.crm.repository.UserRepository;
//
//@Service
//public class UserRoleService {
//
//	@Autowired
//	UserRepository userRepository;
//
//	public UserModel execute(UserRoleDTO userRoleDTO) {
//
//		Optional<UserModel> userExists = userRepository.findById(userRoleDTO.getIdUser());
//		List<Role> roles = new ArrayList<>();
//
//		if (userExists.isEmpty()) {
//			throw new Error("UserModel does not exists!");
//		}
//
//		roles = userRoleDTO.getIdsRoles().stream().map(role -> {
//			return new Role(role);
//		}).collect(Collectors.toList());
//
//		UserModel user = userExists.get();
//
//		user.setRoles(roles);
//
//		userRepository.save(user);
//
//		return user;
//	}
//}
