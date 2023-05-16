package com.matheus.crm.dto;

import java.io.Serializable;
import java.util.Date;

import com.matheus.crm.entity.Customer;
import com.matheus.crm.entity.Order;
import com.matheus.crm.entity.Payment;
import com.matheus.crm.entity.ShippingCompany;
import com.matheus.crm.entity.enums.StatusOrder;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	 public Long id;
	    public Date requestedDate;
	    public Date plannedDate;
	    public Customer customer;
//	    public ArrayList<SaleItem> saleItem = new ArrayList<>();
	    public StatusOrder statusOrder;
	    public Double totalValue;
	    public ShippingCompany shippingCompany;
	    public Payment payment;
	    
	    public OrderDTO(Order entity) {
			this.id = entity.getId();
			this.requestedDate = entity.getRequestedDate();
			this.plannedDate = entity.getPlannedDate();
			this.customer = entity.getCustomer();
			this.statusOrder = entity.getStatusOrder();
			this.totalValue = entity.getTotalValue();
			this.shippingCompany = entity.getShippingCompany();
			this.payment = entity.getPayment();
//			this.products = entity.getProducts();
		}
	  
	    
		public OrderDTO() {
		}
		
		
		public OrderDTO(Long id, Date requestedDate, Date plannedDate, Customer customer, StatusOrder statusOrder,
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
