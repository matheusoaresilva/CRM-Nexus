package com.matheus.crm.customer.controller;

import com.matheus.crm.customer.dto.CustomerDTO;
import com.matheus.crm.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable(name = "id") Long id){
        CustomerDTO customer = customerService.findCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping()
    public Page<CustomerDTO> getAllCustomers(@PageableDefault(size = 10)Pageable pageable){
        return customerService.getAllCustomers(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();

    }


    @PostMapping()
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDto) {
        customerDto = customerService.createCustomer(customerDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customerDto.getId()).toUri();
        return ResponseEntity.created(uri).body(customerDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable(name = "id") Long id ,@RequestBody CustomerDTO customerDto) {
        customerDto = customerService.updateCustomer(id, customerDto);

        return ResponseEntity.ok().body(customerDto);
    }
}

