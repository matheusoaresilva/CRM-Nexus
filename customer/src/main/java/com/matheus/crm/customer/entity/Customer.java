package com.matheus.crm.customer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateBirth;
    @Column
    private String cpf;
    @Column
    private String gender;
    @Column
    private String phone;
    @Column
    private String email;

    @Column
    private Long addressId;

}
