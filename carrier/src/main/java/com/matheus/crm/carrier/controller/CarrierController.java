package com.matheus.crm.carrier.controller;

import com.matheus.crm.carrier.dto.CarrierDTO;
import com.matheus.crm.carrier.entity.Carrier;
import com.matheus.crm.carrier.service.CarrierService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
