package com.matheus.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.crm.entity.Customer;
import com.matheus.crm.exception.NotFoundException;
import com.matheus.crm.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Optional<Customer> findCustomerById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (!customerOptional.isPresent()) {
			throw new NotFoundException("ID: " + id + " not found!");
		}
		return customerOptional;
	}
}
