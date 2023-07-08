package com.matheus.crm.supplier.repository;

import com.matheus.crm.supplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRespository extends JpaRepository<Supplier, Long> {
}
