package com.matheus.crm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.entity.Customer;
import com.matheus.crm.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer/{id}")
	@ResponseBody
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable(name = "id") Long id){
		Optional<Customer> customer = customerService.findCustomerById(id);
		if (customer == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);
	}
}
