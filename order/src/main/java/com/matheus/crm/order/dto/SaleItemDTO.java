package com.matheus.crm.order.dto;

import com.matheus.crm.order.entity.SaleItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;
    public Integer quantity;

    public String description;

}
