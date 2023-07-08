package com.matheus.crm.supplier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;
    public Integer quantityInStock;

    public String description;
}
