package com.matheus.crm.customer.service;

import com.matheus.crm.customer.dto.CustomerDTO;
import com.matheus.crm.customer.entity.Customer;
import com.matheus.crm.customer.repository.CustomerRepository;
import com.matheus.crm.customer.service.exception.DatabaseException;
import com.matheus.crm.customer.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public CustomerDTO findCustomerById(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Id "+ id + " not found!"));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Transactional(readOnly = true)
    public Page<CustomerDTO> getAllCustomers(Pageable pageable){
        return customerRepository.findAll(pageable)
                .map(p -> modelMapper.map(p, CustomerDTO.class));
    }

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO dto){
        Customer customer = customerRepository.save(modelMapper.map(dto, Customer.class));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Transactional
    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("customer not found for id: " + id));

        modelMapper.map(dto, customer);
        Customer saveCustomer = customerRepository.save(customer);

        return modelMapper.map(saveCustomer, CustomerDTO.class);
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
