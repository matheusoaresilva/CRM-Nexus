package com.matheus.crm.customer.dto;

import com.matheus.crm.customer.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;
    public String name;
    public Date dateBirth;
    public String cpf;
    public String gender;
    public String phone;
    public String email;
    public Long addressId;

    public CustomerDTO(Customer entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.dateBirth = entity.getDateBirth();
        this.cpf = entity.getCpf();
        this.gender = entity.getGender();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
        this.addressId = entity.getAddressId();
    }
}
