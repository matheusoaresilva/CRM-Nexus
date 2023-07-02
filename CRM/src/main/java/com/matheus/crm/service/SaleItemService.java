package com.matheus.crm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.SaleDTO;
import com.matheus.crm.entity.Sale;
import com.matheus.crm.repository.SaleRepository;

@Service
public class SaleItemService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Transactional(readOnly = true)
	public List<SaleDTO> findAllSales() {
		List<Sale> list = saleRepository.findAll();
		
		List<SaleDTO> listDto = list.stream()
				.map(x -> new SaleDTO(x)).collect(Collectors.toList()); 
		return listDto;
	}

}
