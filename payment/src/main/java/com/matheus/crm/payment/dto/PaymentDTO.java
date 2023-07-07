package com.matheus.crm.payment.dto;

import com.matheus.crm.payment.entity.Payment;
import com.matheus.crm.payment.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;

    public BigDecimal price;

    public String name;

    public String number;

    public String expiration;

    public String cvv;
    public Status status;

    public Long orderId;

    public PaymentDTO(Payment entity) {
        this.id = entity.getId();
        this.price = entity.getPrice();
        this.name = entity.getName();
        this.number = entity.getNumber();
        this.expiration = entity.getExpiration();
        this.cvv = entity.getCvv();
        this.status = entity.getStatus();
        this.orderId = entity.getOrderId();
    }
}
