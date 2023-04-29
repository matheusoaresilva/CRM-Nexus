package com.matheus.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheus.crm.entity.Product;
import com.matheus.crm.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product findProductBySku(Integer sku){
		Product product = productRepository.findBySku(sku);
		return product;
	}
}
