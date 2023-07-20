package com.matheus.crm.product.dto;

import com.matheus.crm.product.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;
    public String name;
    public String description;
    public Double price;
    public String imgUrl;
    public Category category;
    public Integer sku;
    public Long supplierId;

}
