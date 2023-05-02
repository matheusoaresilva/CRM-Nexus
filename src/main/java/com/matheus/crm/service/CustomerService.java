package com.matheus.crm.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.CustomerDTO;
import com.matheus.crm.entity.Customer;
import com.matheus.crm.repository.CustomerRepository;
import com.matheus.crm.service.exception.DatabaseException;
import com.matheus.crm.service.exception.NotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional(readOnly = true)
	public CustomerDTO findCustomerById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		Customer entity = customerOptional.orElseThrow(() -> new NotFoundException("ID: " + id + " not found!"));
		return new CustomerDTO(entity);

	}

	@Transactional(readOnly = true)
	public List<CustomerDTO> findAllCustomers() {
		List<Customer> list = customerRepository.findAll();

		List<CustomerDTO> listDto = list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
		return listDto;
	}

	@Transactional
	public CustomerDTO addCustomer(CustomerDTO customer) {
		Customer entity = new Customer();
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		entity.setDateBirth(customer.getDateBirth());
		entity.setCpf(customer.getCpf());
		entity.setGender(customer.getGender());
		entity.setPhone(customer.getPhone());
		entity.setEmail(customer.getEmail());
		entity.setAddress(customer.getAddress());

		entity = customerRepository.save(entity);
		return new CustomerDTO(entity);
	}

	@Transactional
	public CustomerDTO updateCustomer(Long id, CustomerDTO customer) {
		Customer entity = customerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("customer not found for id: " + id));
		
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		entity.setDateBirth(customer.getDateBirth());
		entity.setCpf(customer.getCpf());
		entity.setGender(customer.getGender());
		entity.setPhone(customer.getPhone());
		entity.setEmail(customer.getEmail());
		entity.setAddress(customer.getAddress());

		Customer updatedcustomer = customerRepository.save(entity);

		return new CustomerDTO(updatedcustomer);
	}
	
	public void deleteCustomerById(Long id) {
		try {
			customerRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("Id not found!");
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
