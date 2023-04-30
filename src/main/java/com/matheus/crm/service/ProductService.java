package com.matheus.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matheus.crm.entity.Product;
import com.matheus.crm.exception.NotFoundException;
import com.matheus.crm.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Optional<Product> findProductBySku(Integer sku){
		Optional<Product> productOptional = productRepository.findProductBySku(sku);
		if (!productOptional.isPresent()) {
			System.out.println("TEST ERROR SKU");
			throw new NotFoundException("SKU: " + sku + " not found!");
			
		}
		return productOptional;
	}
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	public Product deleteProductBySku(Integer sku) {
		Optional<Product> optionalProduct = productRepository.findProductBySku(sku);
		if (!optionalProduct.isPresent()) {
			throw new NotFoundException("Product with SKU: " + sku + " not found!");
		}
		Product product = optionalProduct.get();
		productRepository.delete(product);
		return product;
		
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
}
