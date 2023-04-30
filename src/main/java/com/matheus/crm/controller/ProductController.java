package com.matheus.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.entity.Product;
import com.matheus.crm.exception.NotFoundException;
import com.matheus.crm.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(
			value = "/product/sku/{sku}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Product>> findProductBySku(@PathVariable(name = "sku") Integer sku) {
		Optional<Product> product = productService.findProductBySku(sku);
		System.out.println("TEST FIND SKU");
		return ResponseEntity.ok(product);
	}
	
	@RequestMapping(
			value = "/getproducts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Product>> getProducts(){
		List<Product> products = productService.findAllProducts();
		if (products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(
			value = "/deleteproducts/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteProducts(@PathVariable(name = "id")Long id){
		try {
			productService.deleteProductById(id);
			System.out.println("id: " + id + " deleted");
			return ResponseEntity.noContent().build();
			
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
}
