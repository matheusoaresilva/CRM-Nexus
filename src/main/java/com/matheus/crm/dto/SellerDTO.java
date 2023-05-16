package com.matheus.crm.dto;

import java.io.Serializable;

import com.matheus.crm.entity.Address;
import com.matheus.crm.entity.Seller;
import com.matheus.crm.entity.enums.LevelAccess;
import com.matheus.crm.entity.enums.StatusProfile;

public class SellerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Long id;
	public String name;
    public String phone;
    public String email;
    public String cpf;
    public Address address;
    public Double commission;
    public StatusProfile statusProfile;
    public LevelAccess levelAccess;
    

    
	public SellerDTO() {

	}
	
	public SellerDTO(Seller entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.phone = entity.getPhone();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.address = entity.getAddress();
		this.commission = entity.getCommission();
		this.statusProfile = entity.getStatusProfile();
		this.levelAccess = entity.getLevelAccess();
	}
	

	public SellerDTO(Long id, String name, String phone, String email, String cpf, Address address, Double commission,
			StatusProfile statusProfile, LevelAccess levelAccess) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.cpf = cpf;
		this.address = address;
		this.commission = commission;
		this.statusProfile = statusProfile;
		this.levelAccess = levelAccess;
	}
	
	
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	public StatusProfile getStatusProfile() {
		return statusProfile;
	}
	public void setStatusProfile(StatusProfile statusProfile) {
		this.statusProfile = statusProfile;
	}
	public LevelAccess getLevelAccess() {
		return levelAccess;
	}
	public void setLevelAccess(LevelAccess levelAccess) {
		this.levelAccess = levelAccess;
	}

    
    
    
}
