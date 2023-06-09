package com.matheus.crm.controller;

import java.util.List;

import com.matheus.crm.security.TokensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.entity.User;
import com.matheus.crm.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

//	@Autowired
//	UserRoleService userRoleService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	TokensService tokenService;

	@RequestMapping(
			value = "/user/create", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody User user) {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
				new UsernamePasswordAuthenticationToken(
						user.getUsername(), user.getPassword()
				);

		Authentication authenticate = this.authenticationManager
				.authenticate(usernamePasswordAuthenticationToken);

		var usuario = (User) authenticate.getPrincipal();

		return  tokenService.gerarToken(usuario);

	  }

//	@RequestMapping(
//			value = "/user/create", consumes = "application/json", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
//		userDTO = userService.execute(userDTO);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(userDTO.getId()).toUri();
//		return ResponseEntity.created(uri).body(userDTO);
//	}

//	@RequestMapping(
//			value = "/user/role", consumes = "application/json", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<UserRoleDTO> createRole(@RequestBody UserRoleDTO userRoleDTO){
//		userRoleDTO = userRoleService.execute(userRoleDTO);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(userRoleDTO.getId()).toUri();
//		return ResponseEntity.created(uri).body(userRoleDTO);
//	}


//	@RequestMapping(
//			value = "/user/role", consumes = "application/json", method = RequestMethod.POST)
//	@ResponseBody
//	public User role(@RequestBody UserRoleDTO userRoleDTO) {
//		return userRoleService.execute(userRoleDTO);
//	}

//	@PreAuthorize("hasRole('ADMIN')")


//	@RequestMapping(
//			value = "/getusers", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<List<UserDTO>> getUsers(){
//		List<UserDTO> users = userService.findAllUsers();
//		if (users.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.ok().body(users);
//	}

}
