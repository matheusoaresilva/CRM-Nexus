package com.matheus.crm.service;

import java.util.List; 
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheus.crm.dto.ProductDTO;
import com.matheus.crm.entity.Product;
import com.matheus.crm.service.exception.NotFoundException;

import com.matheus.crm.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public ProductDTO findProductBySku(Integer sku){
		Optional<Product> productOptional = productRepository.findProductBySku(sku);
		if (!productOptional.isPresent()) {
			System.out.println("TEST ERROR SKU");
			throw new NotFoundException("SKU: " + sku + " not found!");
			
		}
		Product entity = productOptional.get();
		return new ProductDTO(entity);
		
	}
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAllProducts(){
		List<Product> list = productRepository.findAll();
		
		List<ProductDTO> listDto = list.stream()
				.map(x -> new ProductDTO(x)).collect(Collectors.toList());
		return listDto;
	}
	
	@Transactional
	public Product deleteProductBySku(Integer sku) {
		Optional<Product> optionalProduct = productRepository.findProductBySku(sku);
		if (!optionalProduct.isPresent()) {
			throw new NotFoundException("Product with SKU: " + sku + " not found!");
		}
		Product product = optionalProduct.get();
		productRepository.delete(product);
		return product;
		
	}
	
	@Transactional
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
}
