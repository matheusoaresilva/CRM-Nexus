package com.matheus.crm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "payment")
@Entity(name = "payment")
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
    private String name;
	@Column
    private Integer invoicingDay;
	
	
	
	public Payment() {
	}

	public Payment(Long id, String name, Integer invoicingDay) {
		this.id = id;
		this.name = name;
		this.invoicingDay = invoicingDay;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getInvoicingDay() {
		return invoicingDay;
	}
	public void setInvoicingDay(Integer invoicingDay) {
		this.invoicingDay = invoicingDay;
	}

    //Adicionar metodo de calcular taxa
	
	
    
}
