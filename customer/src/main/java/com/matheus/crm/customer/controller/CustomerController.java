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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
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
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO dto, UriComponentsBuilder builder) {
        CustomerDTO customer = customerService.createCustomer(dto);
        URI uri = builder.path("/customers/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id ,@RequestBody CustomerDTO dto) {
        CustomerDTO customer = customerService.updateCustomer(id, dto);

        return ResponseEntity.ok().body(dto);
    }
}

