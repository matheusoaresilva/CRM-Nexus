package com.matheus.crm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.matheus.crm.entity.enums.StatusOrder;

@Table(name = "order_request")
@Entity(name = "order_request")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "requested_date")
	private Date requestedDate;

	@Column(name = "planned_date")
	private Date plannedDate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "status_order")
	private StatusOrder statusOrder;

	@Column(name = "total_value")
	private Double totalValue;

	@ManyToOne
	@JoinColumn(name = "shipping_company_id")
	private ShippingCompany shippingCompany;

	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	public Order() {

	}

	public Order(Long id, Date requestedDate, Date plannedDate, Customer customer, StatusOrder statusOrder,
			Double totalValue, ShippingCompany shippingCompany, Payment payment) {
		this.id = id;
		this.requestedDate = requestedDate;
		this.plannedDate = plannedDate;
		this.customer = customer;
		this.statusOrder = statusOrder;
		this.totalValue = totalValue;
		this.shippingCompany = shippingCompany;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Date getPlannedDate() {
		return plannedDate;
	}

	public void setPlannedDate(Date plannedDate) {
		this.plannedDate = plannedDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public StatusOrder getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(StatusOrder statusOrder) {
		this.statusOrder = statusOrder;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
