package com.matheus.crm.product.entity;

import com.matheus.crm.product.entity.enums.Category;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Double price;
    @Column
    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    private Integer sku;

    @Column
    private Long supplierId;
}
