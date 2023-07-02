package com.matheus.crm.dto;

import java.io.Serializable;

import com.matheus.crm.entity.Address;

public class AddressDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Long id;
    public String street;
    public Integer number;
    public String neighborhood;
    public String city;
    public String state;
    public String country;
    public String zipcode;
    
    public AddressDTO(Address entity) {
    	this.id = entity.getId();
		this.street = entity.getStreet();
		this.number = entity.getNumber();
		this.neighborhood = entity.getNeighborhood();
		this.city = entity.getCity();
		this.state = entity.getState();
		this.country = entity.getCountry();
		this.zipcode = entity.getZipcode();
    }
    
    
	public AddressDTO() {
	}


	public AddressDTO(Long id, String street, Integer number, String neighborhood, String city, String state,
			String country, String zipcode) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getNeighborhood() {
		return neighborhood;
	}


	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
    
    

}
