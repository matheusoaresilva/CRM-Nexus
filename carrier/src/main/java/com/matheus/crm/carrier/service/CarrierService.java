package com.matheus.crm.carrier.service;

import com.matheus.crm.carrier.dto.CarrierDTO;
import com.matheus.crm.carrier.entity.Carrier;
import com.matheus.crm.carrier.repository.CarrierRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarrierService {

    @Autowired
    private CarrierRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    public CarrierDTO createCarrier(CarrierDTO dto){
        Carrier carrier = modelMapper.map(dto, Carrier.class);
        carrier.setTrackingCode(UUID.randomUUID());
        repository.save(carrier);
        return modelMapper.map(carrier, CarrierDTO.class);
    }


}
