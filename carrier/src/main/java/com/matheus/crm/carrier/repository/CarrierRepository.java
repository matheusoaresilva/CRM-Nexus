package com.matheus.crm.carrier.repository;

import com.matheus.crm.carrier.entity.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {


}
