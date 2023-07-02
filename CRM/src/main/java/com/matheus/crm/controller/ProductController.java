//package com.matheus.crm.controller;
//
//import java.net.URI;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.matheus.crm.dto.ProductDTO;
//import com.matheus.crm.service.ProductService;
//
//@Controller
//public class ProductController {
//
//	@Autowired
//	private ProductService productService;
//
//	@RequestMapping(
//			value = "/product/sku/{sku}", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<ProductDTO> findProductBySku(@PathVariable(name = "sku") Integer sku) {
//		ProductDTO product = productService.findProductBySku(sku);
//		System.out.println("TEST FIND SKU");
//		return ResponseEntity.ok(product);
//	}
//
//	@RequestMapping(
//			value = "/getproducts", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<List<ProductDTO>> getProducts(){
//		List<ProductDTO> products = productService.findAllProducts();
//		if (products.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.ok().body(products);
//	}
//
//	@RequestMapping(
//			value = "/deleteproduct/{sku}", method = RequestMethod.DELETE)
//	@ResponseBody
//	public ResponseEntity<Void> deleteProducts(@PathVariable(name = "sku")Integer sku){
//		productService.deleteProductBySku(sku);
//		return ResponseEntity.noContent().build();
//	}
//
//
//	@RequestMapping(
//			value = "/createproduct", consumes = "application/json", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDto) {
//		productDto = productService.addProduct(productDto);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(productDto.getId()).toUri();
//		return ResponseEntity.created(uri).body(productDto);
//	}
//
//	@RequestMapping(
//			value = "/updateproduct/{id}", consumes = "application/json" , method = RequestMethod.PUT)
//	@ResponseBody
//	public ResponseEntity<ProductDTO> updateProduct(@PathVariable(name = "id") Long id ,@RequestBody ProductDTO productDto) {
//		productDto = productService.updateProduct(id, productDto);
//
//		return ResponseEntity.ok().body(productDto);
//	}
//}