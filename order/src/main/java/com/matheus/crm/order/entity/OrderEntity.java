package com.matheus.crm.order.entity;


import com.matheus.crm.order.entity.enums.Status;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime requestedDate;

    @Enumerated(EnumType.STRING)
    private Status status;


    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private List<SaleItem> items = new ArrayList<>();

}
