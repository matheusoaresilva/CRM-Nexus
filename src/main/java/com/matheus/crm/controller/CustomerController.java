package com.matheus.crm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.crm.dto.CustomerDTO;
import com.matheus.crm.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(
			value = "/customer/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable(name = "id") Long id){
		CustomerDTO customer = customerService.findCustomerById(id);
		return ResponseEntity.ok(customer);
	}
	
	@RequestMapping(
			value = "/getcustomers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<CustomerDTO>> getCustomers(){
		List<CustomerDTO> customers = customerService.findAllCustomers();
		if (customers.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(customers);
	}
	
	@RequestMapping(
			value = "/createcustomer", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDto) {
		customerDto = customerService.addCustomer(customerDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(customerDto.getId()).toUri();
		return ResponseEntity.created(uri).body(customerDto);
	}
}
