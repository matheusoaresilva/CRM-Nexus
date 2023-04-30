package com.matheus.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.entity.Customer;
import com.matheus.crm.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(
			value = "/customer/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable(name = "id") Long id){
		Optional<Customer> customer = customerService.findCustomerById(id);
		return ResponseEntity.ok(customer);
	}
	
	@RequestMapping(
			value = "/getcustomers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer> customers = customerService.findAllCustomers();
		if (customers.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(customers);
	}
	
	@RequestMapping(
			value = "/createcustomer", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Customer createCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.addCustomer(customer);
		return newCustomer;
	}
}
