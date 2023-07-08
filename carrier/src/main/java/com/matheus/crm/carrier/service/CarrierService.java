package com.matheus.crm.carrier.service;

import com.matheus.crm.carrier.dto.CarrierDTO;
import com.matheus.crm.carrier.entity.Carrier;
import com.matheus.crm.carrier.entity.enums.DeliveryStatus;
import com.matheus.crm.carrier.repository.CarrierRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
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
        carrier.setStatus(DeliveryStatus.PENDING);
        repository.save(carrier);
        return modelMapper.map(carrier, CarrierDTO.class);
    }

    public CarrierDTO updateCarrier(Long id, CarrierDTO dto){
        Carrier carrier = modelMapper.map(dto, Carrier.class);

        carrier.setId(id);
        carrier = repository.save(carrier);

        return modelMapper.map(carrier, CarrierDTO.class);
    }

    public Page<CarrierDTO> getAllCarriers(Pageable pageable){
        return repository
                .findAll(pageable)
                .map(p-> modelMapper.map(p, CarrierDTO.class));

    }

    public CarrierDTO findById(Long id){
        Carrier carrier = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(carrier, CarrierDTO.class);
    }

    public void deleteCarrierById(Long id){
        repository.deleteById(id);
    }

    public void confirmedDelivery(Long id){
        Optional<Carrier> carrier = repository.findById(id);

        if (!carrier.isPresent()){
            throw new EntityNotFoundException();
        }

        carrier.get().setStatus(DeliveryStatus.DELIVERED);
        repository.save(carrier.get());
    }

}
