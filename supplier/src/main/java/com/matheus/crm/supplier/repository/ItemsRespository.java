package com.matheus.crm.supplier.repository;

import com.matheus.crm.supplier.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRespository extends JpaRepository<Items, Long > {
}
