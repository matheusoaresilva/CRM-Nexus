package com.matheus.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.crm.entity.Address;

@Repository
public interface CategoryRepository extends JpaRepository<Address, Long>{

}
