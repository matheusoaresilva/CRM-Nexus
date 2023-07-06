package com.matheus.crm.order.dto;

import com.matheus.crm.order.entity.OrderEntity;
import com.matheus.crm.order.entity.SaleItem;
import com.matheus.crm.order.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;
    public LocalDateTime requestedDate;
    public List<SaleItem> saleItem = new ArrayList<>();
    public Status status;
    public Long shippingCompanyId;

    public OrderDTO(OrderEntity entity) {
        this.id = entity.getId();
        this.requestedDate = entity.getRequestedDate();
        this.saleItem = entity.getItems();
        this.status = entity.getStatus();
        this.shippingCompanyId = entity.getShippingCompanyId();
    }
}
