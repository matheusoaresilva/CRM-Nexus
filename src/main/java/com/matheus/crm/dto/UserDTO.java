package com.matheus.crm.dto;

import java.io.Serializable;
import java.util.List;

import com.matheus.crm.entity.Role;
import com.matheus.crm.entity.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String username;
	private String password;
//	private List<Role> roles;
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.username = entity.getName();
		this.password = entity.getPassword();
//		this.roles = entity.getRoles();
	}
	
	public UserDTO() {
		super();
	}
	
	
	public UserDTO(Long id, String name, String username, String password
	) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
//		this.roles = roles;
	}

//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
