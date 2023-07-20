package com.matheus.crm.address.service;

import com.matheus.crm.address.dto.AddressDTO;
import com.matheus.crm.address.entity.Address;
import com.matheus.crm.address.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<AddressDTO> getAllAddresses(Pageable pageable){
       return repository.findAll(pageable)
                .map(p-> modelMapper.map(p, AddressDTO.class));
    }

    public AddressDTO findAddressById(Long id){
        Address address = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Address with id: "+ id +" not found!"));

        return modelMapper.map(address, AddressDTO.class);
    }

    @Transactional
    public AddressDTO createAddress(AddressDTO dto){
        Address address = repository.save(modelMapper.map(dto, Address.class));

        return modelMapper.map(address, AddressDTO.class);
    }

    public AddressDTO updateAddress(Long id, AddressDTO dto){
        Address address = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Address with id: "+ id +" not found!"));

        modelMapper.map(dto, address);
        Address saveAddress = repository.save(address);

        return modelMapper.map(saveAddress, AddressDTO.class);
    }

    public void deleteAddressById(Long id){
       repository.deleteById(id);
    }

}
