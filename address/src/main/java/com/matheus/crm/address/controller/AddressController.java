package com.matheus.crm.address.controller;

import com.matheus.crm.address.dto.AddressDTO;
import com.matheus.crm.address.entity.Address;
import com.matheus.crm.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping()
    public Page<AddressDTO> getAllAddresses(@PageableDefault(size = 10)Pageable pageable){
        return addressService.getAllAddresses(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findAddressById(@PathVariable Long id){
        AddressDTO dto = addressService.findAddressById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping()
    public ResponseEntity<AddressDTO> createAddresses(@RequestBody AddressDTO dto, UriComponentsBuilder builder){
        AddressDTO address = addressService.createAddress(dto);

        URI uri = builder.path("/addresses/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> updateAddresses(@PathVariable Long id, @RequestBody AddressDTO dto){
        AddressDTO address = addressService.updateAddress(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
         addressService.deleteAddressById(id);

         return ResponseEntity.ok().body("deleted!");
    }

}
