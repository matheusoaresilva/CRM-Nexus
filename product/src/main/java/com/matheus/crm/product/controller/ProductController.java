package com.matheus.crm.product.controller;

import com.matheus.crm.product.dto.ProductDTO;
import com.matheus.crm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductDTO> findProductBySku(@PathVariable(name = "sku") Integer sku) {
        ProductDTO product = productService.findProductBySku(sku);
        System.out.println("TEST FIND SKU");
        return ResponseEntity.ok(product);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getProducts(){
        List<ProductDTO> products = productService.findAllProducts();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(products);
    }


    @DeleteMapping("/delete/{sku}")
    public ResponseEntity<Void> deleteProducts(@PathVariable(name = "sku")Integer sku){
        productService.deleteProductBySku(sku);
        return ResponseEntity.noContent().build();
    }



    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDto) {
        productDto = productService.addProduct(productDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productDto.getId()).toUri();
        return ResponseEntity.created(uri).body(productDto);
    }


    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable(name = "id") Long id ,@RequestBody ProductDTO productDto) {
        productDto = productService.updateProduct(id, productDto);

        return ResponseEntity.ok().body(productDto);
    }
}
