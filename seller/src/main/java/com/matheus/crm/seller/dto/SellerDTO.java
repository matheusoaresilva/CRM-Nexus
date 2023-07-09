package com.matheus.crm.seller.dto;

import com.matheus.crm.seller.entity.enums.StatusProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;

    public String name;

    public String email;

    public StatusProfile profile;

    public Long addressId;

}
