package com.matheus.crm.dto;

import java.util.List;

public class UserRoleDTO {

	private Long idUser;
	private List<Long> idsRoles;
	
	
	public UserRoleDTO() {
		super();
	}
	
	public UserRoleDTO(Long idUser, List<Long> idsRoles) {
		super();
		this.idUser = idUser;
		this.idsRoles = idsRoles;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public List<Long> getIdsRoles() {
		return idsRoles;
	}
	public void setIdsRoles(List<Long> idsRoles) {
		this.idsRoles = idsRoles;
	}
	
	
}
