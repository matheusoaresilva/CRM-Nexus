package com.matheus.crm.carrier.dto;

import com.matheus.crm.carrier.entity.Carrier;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrierDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;
    public String name;
    public UUID trackingCode;
    public Long orderId;

    public CarrierDTO(Carrier entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.trackingCode = entity.getTrackingCode();
        this.orderId = entity.getOrderId();
    }
}
