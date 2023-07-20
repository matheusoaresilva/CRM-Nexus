package com.matheus.crm.product.service;

import com.matheus.crm.product.dto.ProductDTO;
import com.matheus.crm.product.entity.Product;
import com.matheus.crm.product.repository.ProductRepository;
import com.matheus.crm.product.service.exception.DatabaseException;
import com.matheus.crm.product.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ProductDTO findProductBySku(Integer sku){
        Product product = productRepository.findProductBySku(sku)
                .orElseThrow(()-> new EntityNotFoundException("Product with sku " +sku+ "not found!" ));

        return modelMapper.map(product, ProductDTO.class);
    }

    public Page<ProductDTO> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable)
                .map(p ->modelMapper.map(p, ProductDTO.class));
    }

    @Transactional
    public void deleteProductBySku(Integer sku) {
        try {
            productRepository.deleteBySku(sku);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("SKU not found!");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        };

    }

    @Transactional
    public ProductDTO createProduct(ProductDTO dto) {
        Product product = productRepository.save(modelMapper.map(dto, Product.class));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("product not found for id: " + id));

        modelMapper.map(dto, product);
        Product saveProduct = productRepository.save(product);

        return modelMapper.map(saveProduct, ProductDTO.class);
    }
}

