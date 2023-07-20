package com.matheus.crm.product.controller;

import com.matheus.crm.product.dto.ProductDTO;
import com.matheus.crm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductDTO> findProductBySku(@PathVariable(name = "sku") Integer sku) {
        ProductDTO product = productService.findProductBySku(sku);
        return ResponseEntity.ok(product);
    }


    @GetMapping()
    public Page<ProductDTO> getProducts(@PageableDefault(size = 10)Pageable pageable){
        return productService.getAllProducts(pageable);
    }


    @DeleteMapping("/{sku}")
    public ResponseEntity<Void> deleteProducts(@PathVariable(name = "sku")Integer sku){
        productService.deleteProductBySku(sku);
        return ResponseEntity.noContent().build();
    }



    @PostMapping()
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto, UriComponentsBuilder builder) {
        ProductDTO product = productService.createProduct(dto);

        URI uri = builder.path("products/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable(name = "id") Long id ,@RequestBody ProductDTO dto) {
        ProductDTO producto = productService.updateProduct(id, dto);

        return ResponseEntity.ok().body(dto);
    }
}
