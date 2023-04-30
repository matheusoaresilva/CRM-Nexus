package com.matheus.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.crm.entity.Supplier;
import com.matheus.crm.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	
	public Optional<Supplier> findSupplierById(Long id){
		Optional<Supplier> supplier = supplierRepository.findById(id);
		return supplier;
	}
}
