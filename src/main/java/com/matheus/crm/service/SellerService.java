package com.matheus.crm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.SellerDTO;
import com.matheus.crm.entity.Seller;
import com.matheus.crm.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public List<SellerDTO> findAllSellers() {
		List<Seller> list = sellerRepository.findAll();

		List<SellerDTO> listDto = list.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		return listDto;
	}

}
