package com.matheus.crm.supplier.service;

import com.matheus.crm.supplier.dto.SupplierDTO;
import com.matheus.crm.supplier.entity.Supplier;
import com.matheus.crm.supplier.repository.SupplierRespository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {

    @Autowired
    SupplierRespository repository;

    @Autowired
    private final ModelMapper modelMapper;

//    public Page<SupplierDTO> findAllSuppliers(Pageable pageable){
//        return repository
//                .findAll(pageable)
//                .map(p-> modelMapper.map(p, SupplierDTO.class));
//    }

    @Transactional(readOnly = true)
    public List<SupplierDTO> findAll() {
        List<Supplier> list = repository.findAll();

        List<SupplierDTO> listDto = list.stream()
                .map(x -> modelMapper.map(x, SupplierDTO.class)).collect(Collectors.toList());
        return listDto;
    }

    public SupplierDTO findSupplierById(Long id){
        Supplier supplier = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(supplier, SupplierDTO.class);
    }

    @Transactional
    public SupplierDTO createSupplier(SupplierDTO dto){
        Supplier entity = modelMapper.map(dto, Supplier.class);

        entity.getItems().forEach(items -> items.setSupplier(entity));

        Supplier save = repository.save(entity);

        return modelMapper.map(entity, SupplierDTO.class);
    }

    public SupplierDTO updateSupplier(Long id, SupplierDTO dto){
        Supplier supplier = modelMapper.map(dto, Supplier.class);

        supplier.setId(id);
        supplier = repository.save(supplier);

        return modelMapper.map(supplier, SupplierDTO.class);
    }
}
