package com.matheus.crm.supplier.service;

import com.matheus.crm.supplier.dto.ItemsDTO;
import com.matheus.crm.supplier.dto.SupplierDTO;
import com.matheus.crm.supplier.entity.Items;
import com.matheus.crm.supplier.entity.Supplier;
import com.matheus.crm.supplier.repository.ItemsRespository;
import com.matheus.crm.supplier.repository.SupplierRespository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {

    @Autowired
    SupplierRespository supplierRepository;

    @Autowired
    ItemsRespository itemsRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public Page<SupplierDTO> findAllSuppliers(Pageable pageable){
        return supplierRepository
                .findAll(pageable)
                .map(p-> modelMapper.map(p, SupplierDTO.class));
    }


    public SupplierDTO findSupplierById(Long id){
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(supplier, SupplierDTO.class);
    }

    @Transactional
    public SupplierDTO createSupplier(SupplierDTO dto){
        Supplier entity = modelMapper.map(dto, Supplier.class);

        entity.getItems().forEach(items -> items.setSupplier(entity));

        Supplier save = supplierRepository.save(entity);

        return modelMapper.map(entity, SupplierDTO.class);
    }

    public SupplierDTO updateSupplier(Long id, SupplierDTO dto){
        Supplier supplier = modelMapper.map(dto, Supplier.class);

        supplier.setId(id);
        supplier = supplierRepository.save(supplier);

        return modelMapper.map(supplier, SupplierDTO.class);
    }

    public List<ItemsDTO> registerItemsForSupplierById(Long id, List<ItemsDTO> dtos){
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Supplier with id: " + id + " not found!"));

        List<Items> itemsList = dtos.stream()
                .map(dto -> {
                    Items items = modelMapper.map(dto, Items.class);
                    items.setSupplier(supplier);
                    return items;
                })
                        .collect(Collectors.toList());



        List<Items> savedList = itemsRepository.saveAll(itemsList);

        return savedList.stream()
                .map(items -> modelMapper.map(items, ItemsDTO.class))
                .collect(Collectors.toList());
    }
}
