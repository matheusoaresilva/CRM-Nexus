package com.matheus.crm.seller.entity;

import com.matheus.crm.seller.entity.enums.StatusProfile;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "sellers")
@Data
public class Seller implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @Enumerated(EnumType.STRING)
    private StatusProfile profile;

    @NotNull
    private Long addressId;

    //TODO fazer lista de orders ligado a cada seller

}
