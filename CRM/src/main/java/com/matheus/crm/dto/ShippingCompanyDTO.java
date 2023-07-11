//package com.matheus.crm.dto;
//
//import java.io.Serializable;
//
//import com.matheus.crm.entity.ShippingCompany;
//
//public class ShippingCompanyDTO implements Serializable{
//
//	public static final long serialVersionUID = 1L;
//
//	public Long id;
//    public String name;
//    public String cnpj;
//    public String phone;
//    public String email;
//
//
//	public ShippingCompanyDTO() {
//	}
//
//	public ShippingCompanyDTO(ShippingCompany entity) {
//		this.id = entity.getId();
//		this.name = entity.getName();
//		this.cnpj = entity.getCnpj();
//		this.phone = entity.getPhone();
//		this.email = entity.getEmail();
//	}
//
//	public ShippingCompanyDTO(Long id, String name, String cnpj, String phone, String email) {
//		this.id = id;
//		this.name = name;
//		this.cnpj = cnpj;
//		this.phone = phone;
//		this.email = email;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getCnpj() {
//		return cnpj;
//	}
//	public void setCnpj(String cnpj) {
//		this.cnpj = cnpj;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//}
