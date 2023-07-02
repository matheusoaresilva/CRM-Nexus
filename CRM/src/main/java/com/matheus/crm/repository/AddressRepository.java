package com.matheus.crm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.crm.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	Optional<Address> findById(Long id);
}
