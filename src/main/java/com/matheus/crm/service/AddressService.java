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
import com.matheus.crm.repository.AddressRepository;
import com.matheus.crm.service.exception.NotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Transactional(readOnly = true)
	public AddressDTO findAddressById(Long id) {
		Optional<Address> addressOptional = addressRepository.findById(id);
		Address entity = addressOptional.orElseThrow(() -> new NotFoundException("ID: " + id + " not found!"));
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
	public AddressDTO addAddress(AddressDTO address) {
		Address entity = new Address();
		entity.setStreet(address.getStreet());
		entity.setNumber(address.getNumber());
		entity.setNeighborhood(address.getNeighborhood());
		entity.setCity(address.getCity());
		entity.setState(address.getState());
		entity.setCountry(address.getCountry());
		entity.setZipcode(address.getZipcode());
		entity = addressRepository.save(entity);
		
		return new AddressDTO(entity);
		
	}

	
	@Transactional
	public AddressDTO updateAddress(Long id, AddressDTO address) {
		Address entity = addressRepository.findById(id)
	            .orElseThrow(() -> new NotFoundException("Address not found for id: " + id));
	    
	    entity.setStreet(address.getStreet());
	    entity.setNumber(address.getNumber());
	    entity.setNeighborhood(address.getNeighborhood());
	    entity.setCity(address.getCity());
	    entity.setState(address.getState());
	    entity.setCountry(address.getCountry());
	    entity.setZipcode(address.getZipcode());

	   
	    Address updatedAddress = addressRepository.save(entity);

	    return new AddressDTO(updatedAddress);
	}

}
