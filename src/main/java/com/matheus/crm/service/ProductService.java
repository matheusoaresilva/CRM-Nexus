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
	
	public void deleteProductById(Long id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException("Product with ID " + id +" not found!");
		}
		
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
}
