package com.matheus.crm.product.repository;


import com.matheus.crm.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductBySku(int sku);

    void deleteBySku(int sku);
}
