package com.matheus.crm.order.dto;

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
