package com.matheus.crm.supplier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;

    public String name;

    public String cnpj;

    public List<ItemsDTO> items = new ArrayList<>();

}
