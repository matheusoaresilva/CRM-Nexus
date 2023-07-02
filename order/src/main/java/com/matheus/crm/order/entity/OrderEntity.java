package com.matheus.crm.order.entity;


import com.matheus.crm.order.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "order")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "requested_date")
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime requestedDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_order")
    private Status status;

    @Column(name = "shipping_company_id")
    private Long shippingCompanyId;

    @Column(nullable = false)
    private List<SaleItem> items = new ArrayList<>();

}
