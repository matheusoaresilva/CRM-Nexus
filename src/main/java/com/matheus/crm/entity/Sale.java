package com.matheus.crm.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.matheus.crm.entity.enums.StatusSale;

@Table(name = "sale")
@Entity(name = "sale")
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
    private LocalDate saleDate;
	
	@Column
    private Double totalValue;
	
	@OneToOne
	@JoinColumn(name = "payment_id")
    private Payment payment;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
    private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "seller_id")
    private Seller seller;
	
	@Enumerated(EnumType.ORDINAL)
	@Column
    private StatusSale statusSale;
//    private ArrayList<Installment> installments = new ArrayList<>();
    
    
    public Sale() {
	}
    
    
    public Sale(Long id, LocalDate saleDate, Double totalValue, Payment payment, Customer customer, Seller seller,
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
