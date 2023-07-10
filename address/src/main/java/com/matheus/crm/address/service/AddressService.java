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
import org.springframework.web.bind.annotation.RequestMapping;

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
        Address address = modelMapper.map(dto, Address.class);

        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setZipcode(dto.getZipcode());

        Address saveAddress = repository.save(address);

        return modelMapper.map(address, AddressDTO.class);
    }

    public AddressDTO updateAddress(Long id, AddressDTO dto){
        Address address = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Address with id: "+ id +" not found!"));

        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setNeighborhood(dto.getNeighborhood());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setZipcode(dto.getZipcode());

        Address saveAddress = repository.save(address);

        return modelMapper.map(address, AddressDTO.class);
    }

    public void deleteAddressById(Long id){
       repository.deleteById(id);
    }

}
