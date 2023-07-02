//package com.matheus.crm.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Table(name = "sale_item")
//@Entity(name = "sale_item")
////public class SaleItem implements Serializable{
//
//	public static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@Column
//    private Integer quantitySold;
//
//	@Column
//    private Double price;
//
//	@ManyToOne
//	@JoinColumn(name = "product_id")
//    private Product product;
//
//	@ManyToOne
//	@JoinColumn(name = "order_id")
//    private Order order;
//
//
//
//
//	public SaleItem() {
//
//	}
//
//	public SaleItem(Long id, Integer quantitySold, Double price, Product product, Order order) {
//		this.id = id;
//		this.quantitySold = quantitySold;
//		this.price = price;
//		this.product = product;
//		this.order = order;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Integer getQuantitySold() {
//		return quantitySold;
//	}
//
//	public void setQuantitySold(Integer quantitySold) {
//		this.quantitySold = quantitySold;
//	}
//
//	public Double getPrice() {
//		return price;
//	}
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//
//
//
//
//}
