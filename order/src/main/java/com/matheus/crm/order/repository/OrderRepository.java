package com.matheus.crm.order.repository;

import com.matheus.crm.order.entity.OrderEntity;
import com.matheus.crm.order.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findById(Long id);

    @Query(value = "SELECT o from OrderEntity o LEFT JOIN FETCH o.items where o.id = :id")
    OrderEntity findByIdFetchItens(Long id);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update OrderEntity o set o.status = :status where o = :order")
    void updateStatusByPedido(Status status, OrderEntity order);
}
