package com.matheus.crm.seller.service;

import com.matheus.crm.seller.dto.SellerDTO;
import com.matheus.crm.seller.entity.Seller;
import com.matheus.crm.seller.entity.enums.StatusProfile;
import com.matheus.crm.seller.repository.SellerRepository;
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
public class SellerService {

    @Autowired
    SellerRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    public Page<SellerDTO> getAllSellers(Pageable pageable){
        return repository
                .findAll(pageable)
                .map(p -> modelMapper.map(p, SellerDTO.class));
    }

    public SellerDTO findSellerById(Long id){
        Seller seller = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Seller with id: "+ id + " not found!"));

        return modelMapper.map(seller, SellerDTO.class);
    }

    @Transactional
    public SellerDTO createSeller(SellerDTO dto){
        dto.setProfile(StatusProfile.ACTIVE);
        Seller seller = repository.save(modelMapper.map(dto, Seller.class));

        return modelMapper.map(seller, SellerDTO.class);
    }

    public SellerDTO updateSeller(Long id, SellerDTO dto){
        Seller seller = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Seller with id: "+ id + " not found!"));

        modelMapper.map(dto, seller);
        Seller saveSeller = repository.save(seller);
        return modelMapper.map(saveSeller, SellerDTO.class);
    }

    public SellerDTO disableUserProfile(Long id){
        Seller seller = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Seller with id: "+ id + " not found!"));

        seller.setProfile(StatusProfile.INACTIVE);

        Seller saveSeller = repository.save(seller);

        return modelMapper.map(seller, SellerDTO.class);
    }
}
