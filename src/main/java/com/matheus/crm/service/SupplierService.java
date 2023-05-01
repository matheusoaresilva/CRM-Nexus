package com.matheus.crm.service;

import java.util.List; 
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.SupplierDTO;
import com.matheus.crm.entity.Supplier;
import com.matheus.crm.service.exception.NotFoundException;

import com.matheus.crm.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Transactional(readOnly = true)
	public SupplierDTO findSupplierById(Long id){
		Optional<Supplier> supplierOptional = supplierRepository.findById(id);
		Supplier entity = supplierOptional.orElseThrow(() -> new NotFoundException("ID: " + id + " not found!"));
		return new SupplierDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<SupplierDTO> findAllSuppliers(){
		List<Supplier> list = supplierRepository.findAll();
		
		List<SupplierDTO> listdDto = list.stream()
				.map(x -> new SupplierDTO(x)).collect(Collectors.toList());
		return listdDto;
	}
	
	@Transactional
	public SupplierDTO addSupplier(SupplierDTO supplier) {
		Supplier entity = new Supplier();
		entity.setName(supplier.getName());
		entity.setEmail(supplier.getEmail());
		entity.setPhone(supplier.getPhone());
		entity.setCnpj(supplier.getCnpj());

		entity =  supplierRepository.save(entity);
		return new SupplierDTO(entity);
	}
	
}
