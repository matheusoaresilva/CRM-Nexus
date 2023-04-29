package com.matheus.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.crm.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
