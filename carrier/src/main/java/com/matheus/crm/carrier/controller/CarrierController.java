package com.matheus.crm.carrier.controller;

import com.matheus.crm.carrier.dto.CarrierDTO;
import com.matheus.crm.carrier.service.CarrierService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/carriers")
public class CarrierController {

    @Autowired
    private CarrierService service;

    @PostMapping()
    public ResponseEntity<CarrierDTO> createCarrier(@RequestBody CarrierDTO carrierDTO, UriComponentsBuilder builder){
        CarrierDTO carrier = service.createCarrier(carrierDTO);

        URI uri =builder.path("/carriers/{id}").buildAndExpand(carrier.getId()).toUri();

        return ResponseEntity.created(uri).body(carrier);
    }

    @GetMapping()
    public Page<CarrierDTO> findAllCarriers(@PageableDefault(size = 10) Pageable p){
        return service.getAllCarriers(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrierDTO> findById(@PathVariable @NotNull Long id){
        CarrierDTO dto = service.findById(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/confirm/{id}")
    public String confirmedDelivery(@PathVariable Long id){
        service.confirmedDelivery(id);

        return "Order with id:"+ id +" was delivered ";
    }
}
