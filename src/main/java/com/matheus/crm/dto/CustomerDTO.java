package com.matheus.crm.dto;

import java.io.Serializable;
import java.util.Date;

import com.matheus.crm.entity.Address;
import com.matheus.crm.entity.Customer;

public class CustomerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Long id;
    public String firstName;
    public String lastName;
    public Date dateBirth;
    public String cpf;
    public String gender;
    public String phone;
    public String email;
    public Address address;
    
	public CustomerDTO() {
	}

	public CustomerDTO(Customer entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.dateBirth = entity.getDateBirth();
		this.cpf = entity.getCpf();
		this.gender = entity.getGender();
		this.phone = entity.getPhone();
		this.email = entity.getEmail();
		this.address = entity.getAddress();
	}


	public CustomerDTO(Long id, String firstName, String lastName, Date dateBirth, String cpf, String gender,
			String phone, String email, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.cpf = cpf;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    
    

}
