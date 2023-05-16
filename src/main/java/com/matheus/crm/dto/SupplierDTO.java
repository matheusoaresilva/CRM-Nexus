package com.matheus.crm.dto;

import java.io.Serializable;

import com.matheus.crm.entity.Address;
import com.matheus.crm.entity.Supplier;

public class SupplierDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long id;
	public String name;
	public String email;
	public String phone;
	public String cnpj;
	public Address address;
//	public List<Product> products;

	public SupplierDTO(Supplier entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.cnpj = entity.getCnpj();
		this.address = entity.getAddress();
//		this.products = entity.getProducts();
	}

	public SupplierDTO() {

	}

	public SupplierDTO(Long id, String name, String email, String phone, String cnpj, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cnpj = cnpj;
		this.address = address;
//		this.products = products;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
	
	

}
