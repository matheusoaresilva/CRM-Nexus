package com.matheus.crm.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.AddressDTO;
import com.matheus.crm.entity.Address;
import com.matheus.crm.exception.NotFoundException;
import com.matheus.crm.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Transactional(readOnly = true)
	public AddressDTO findAddressById(Long id) {
		Optional<Address> addressOptional = addressRepository.findById(id);
		if (!addressOptional.isPresent()) {
			throw new NotFoundException("ID: " + id + " not found!");
		}
		Address entity = addressOptional.get();
		return new AddressDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<AddressDTO> findAllAddress() {
		List<Address> list = addressRepository.findAll();
		
		List<AddressDTO> listDto = list.stream()
				.map(x -> new AddressDTO(x)).collect(Collectors.toList()); 
		return listDto;
	}

	@Transactional
	public void deleteAddressById(Long id) {
		try {
			addressRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("Address not found with ID: " + id);
		}
	}
	
	@Transactional
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}
	
//	@Transactional
//	public Address updateAddress(Address address, Long id) {
//		
//	}

}
