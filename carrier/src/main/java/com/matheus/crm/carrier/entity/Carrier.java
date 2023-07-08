package com.matheus.crm.carrier.entity;


import com.matheus.crm.carrier.entity.enums.DeliveryStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carriers")
public class Carrier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    private UUID trackingCode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    @NotNull
    private Long orderId;
}
