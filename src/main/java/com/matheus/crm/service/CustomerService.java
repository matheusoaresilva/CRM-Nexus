package com.matheus.crm.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.CustomerDTO;
import com.matheus.crm.entity.Customer;
import com.matheus.crm.exception.NotFoundException;
import com.matheus.crm.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional(readOnly = true)
	public CustomerDTO findCustomerById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (!customerOptional.isPresent()) {
			throw new NotFoundException("ID: " + id + " not found!");
		}
		Customer entity = customerOptional.get();
		return new CustomerDTO(entity);
		
	}
	
	@Transactional(readOnly = true)
	public List<CustomerDTO> findAllCustomers(){
		List<Customer> list = customerRepository.findAll();
		
		List<CustomerDTO> listDto = list.stream()
				.map(x -> new CustomerDTO(x)).collect(Collectors.toList());
		return listDto;
	}
	
	@Transactional
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
}
