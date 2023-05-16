package com.matheus.crm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.ShippingCompanyDTO;
import com.matheus.crm.entity.ShippingCompany;
import com.matheus.crm.repository.ShippingCompanyRepository;

@Service
public class ShippingCompanyService {
	
	@Autowired
	private ShippingCompanyRepository shippingCompanyRepository;
	
	@Transactional(readOnly = true)
	public List<ShippingCompanyDTO> findAllshippingCompanys() {
		List<ShippingCompany> list = shippingCompanyRepository.findAll();
		
		List<ShippingCompanyDTO> listDto = list.stream()
				.map(x -> new ShippingCompanyDTO(x)).collect(Collectors.toList()); 
		return listDto;
	}

}
