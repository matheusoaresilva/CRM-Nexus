package com.matheus.crm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.entity.Supplier;
import com.matheus.crm.service.SupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;

	@RequestMapping(
			value = "/supplier/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Supplier> findSupplierById(@PathVariable(name = "id") Long id){
		Optional<Supplier> supplierOptional  = supplierService.findSupplierById(id);
		
		if (!supplierOptional .isPresent()) {
			System.out.println("TESTE NOT FOUND");

			return ResponseEntity.notFound().build();
		}
		Supplier supplier = supplierOptional .get();
		System.out.println("TESTE ok");

		return ResponseEntity.ok(supplier);
	}
}
