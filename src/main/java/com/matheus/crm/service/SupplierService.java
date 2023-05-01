package com.matheus.crm.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.crm.dto.SupplierDTO;
import com.matheus.crm.entity.Supplier;
import com.matheus.crm.exception.NotFoundException;
import com.matheus.crm.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	
	public SupplierDTO findSupplierById(Long id){
		Optional<Supplier> supplierOptional = supplierRepository.findById(id);
		if (!supplierOptional.isPresent()) {
			throw new NotFoundException("ID: " + id + " not found!");
		}
		
		Supplier entity = supplierOptional.get();
		return new SupplierDTO(entity);
	}
	
	public List<SupplierDTO> findAllSuppliers(){
		List<Supplier> list = supplierRepository.findAll();
		
		List<SupplierDTO> listdDto = list.stream()
				.map(x -> new SupplierDTO(x)).collect(Collectors.toList());
		return listdDto;
	}
	
	public Supplier addSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
}
