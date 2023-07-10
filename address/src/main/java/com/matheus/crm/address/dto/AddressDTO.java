package com.matheus.crm.address.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;
    public String street;
    public Integer number;
    public String neighborhood;
    public String city;
    public String state;
    public String country;
    public String zipcode;
}
