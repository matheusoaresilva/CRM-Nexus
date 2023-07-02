package com.matheus.crm.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.matheus.crm.entity.Customer;
import com.matheus.crm.entity.Payment;
import com.matheus.crm.entity.Sale;
import com.matheus.crm.entity.Seller;
import com.matheus.crm.entity.enums.StatusSale;

public class SaleDTO implements Serializable{

	public static final long serialVersionUID = 1L;
	
	public Long id;
    public LocalDate saleDate;
    public Double totalValue;
    public Payment payment;
    public Customer customer;
    public Seller seller;
    public StatusSale statusSale;
    
	public SaleDTO() {
	}

	public SaleDTO(Sale entity) {
		this.id = entity.getId();
		this.saleDate = entity.getSaleDate();
		this.totalValue = entity.getTotalValue();
		this.payment = entity.getPayment();
		this.customer = entity.getCustomer();
		this.seller = entity.getSeller();
		this.statusSale = entity.getStatusSale();
	}

	public SaleDTO(Long id, LocalDate saleDate, Double totalValue, Payment payment, Customer customer, Seller seller,
			StatusSale statusSale) {
		this.id = id;
		this.saleDate = saleDate;
		this.totalValue = totalValue;
		this.payment = payment;
		this.customer = customer;
		this.seller = seller;
		this.statusSale = statusSale;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public StatusSale getStatusSale() {
		return statusSale;
	}
	public void setStatusSale(StatusSale statusSale) {
		this.statusSale = statusSale;
	}
    
    
    
    
	

}
