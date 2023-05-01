package com.matheus.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.dto.ProductDTO;
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
	public ResponseEntity<ProductDTO> findProductBySku(@PathVariable(name = "sku") Integer sku) {
		ProductDTO product = productService.findProductBySku(sku);
		System.out.println("TEST FIND SKU");
		return ResponseEntity.ok(product);
	}
	
	@RequestMapping(
			value = "/getproducts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ProductDTO>> getProducts(){
		List<ProductDTO> products = productService.findAllProducts();
		if (products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(
			value = "/deleteproduct/{sku}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteProducts(@PathVariable(name = "sku")Integer sku){
		try {
			Product deletedProduct =  productService.deleteProductBySku(sku);
			if (deletedProduct == null) {
				return ResponseEntity.notFound().build();
			}
			System.out.println("sku: " + sku + " deleted");
			return ResponseEntity.noContent().build();
			
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@RequestMapping(
			value = "/createproduct", consumes = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Product createProduct(@RequestBody Product product) {
		Product newProduct = productService.addProduct(product);
		return newProduct;
	}
}
