package com.matheus.crm.supplier.controller;

import com.matheus.crm.supplier.dto.SupplierDTO;
import com.matheus.crm.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    SupplierService service;

    @GetMapping()
    public ResponseEntity<List<SupplierDTO>> getAll(){
        List<SupplierDTO> supplier =  service.findAll();
        if (supplier.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(supplier);
    }


//    @GetMapping
//    public Page<SupplierDTO> all(@PageableDefault(size = 10) Pageable pageable){
//        return service.findAllSuppliers(pageable);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> findSupplierById(@PathVariable @NotNull Long id){
        SupplierDTO dto = service.findSupplierById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody @Valid SupplierDTO dto, UriComponentsBuilder builder){
        SupplierDTO supplier = service.createSupplier(dto);

        URI uri = builder.path("/suppliers/{id}").buildAndExpand(supplier.getId()).toUri();

        return ResponseEntity.created(uri).body(supplier);
    }
}
