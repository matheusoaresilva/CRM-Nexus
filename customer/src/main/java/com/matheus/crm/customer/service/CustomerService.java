package com.matheus.crm.customer.service;

import com.matheus.crm.customer.dto.CustomerDTO;
import com.matheus.crm.customer.entity.Customer;
import com.matheus.crm.customer.repository.CustomerRepository;
import com.matheus.crm.customer.service.exception.DatabaseException;
import com.matheus.crm.customer.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public CustomerDTO findCustomerById(Long id){
        Optional<Customer> existingC = customerRepository.findById(id);
        Customer entity =existingC.orElseThrow(()-> new NotFoundException("Id "+ id + " not found!"));
        return new CustomerDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAllCustomers(){
        List<Customer> list = customerRepository.findAll();

        List<CustomerDTO> dtoList = list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
        return dtoList;
    }

    @Transactional
    public CustomerDTO addCustomer(CustomerDTO customer){
        Customer entity = new Customer();

        entity.setName(customer.getName());
        entity.setCpf(customer.getCpf());
        entity.setGender(customer.getGender());
        entity.setPhone(customer.getPhone());
        entity.setDateBirth(customer.getDateBirth());
        entity.setEmail(customer.getEmail());
        entity.setAddressId(customer.getAddressId());

        entity = customerRepository.save(entity);
        return new CustomerDTO(entity);
    }

    @Transactional
    public CustomerDTO updateCustomer(Long id, CustomerDTO customer) {
        Customer entity = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("customer not found for id: " + id));

        entity.setName(customer.getName());
        entity.setDateBirth(customer.getDateBirth());
        entity.setCpf(customer.getCpf());
        entity.setGender(customer.getGender());
        entity.setPhone(customer.getPhone());
        entity.setEmail(customer.getEmail());
        entity.setAddressId(customer.getAddressId());

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
