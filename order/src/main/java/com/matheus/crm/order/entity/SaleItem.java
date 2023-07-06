package com.matheus.crm.order.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "item")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Positive
    private Integer quantity;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private OrderEntity order;
}
