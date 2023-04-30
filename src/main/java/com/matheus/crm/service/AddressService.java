package com.matheus.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.crm.entity.Address;
import com.matheus.crm.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	
	public Optional<Address> findAddressById(Long id){
		Optional<Address> address = addressRepository.findById(id);
		return address;
	}
}
