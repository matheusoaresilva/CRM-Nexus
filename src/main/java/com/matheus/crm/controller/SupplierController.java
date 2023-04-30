package com.matheus.crm.controller;

import java.util.List;
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
	public ResponseEntity<Optional<Supplier>> findSupplierById(@PathVariable(name = "id") Long id){
		Optional<Supplier> supplier  = supplierService.findSupplierById(id);
		return ResponseEntity.ok(supplier);
	}
	
	@RequestMapping(
			value = "/getsuppliers",  method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Supplier>> getSuppliers(){
		List<Supplier> suppliers = supplierService.findAllSuppliers();
		if (suppliers.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(suppliers);
	}
}
