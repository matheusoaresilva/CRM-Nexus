package com.matheus.crm.dto;

import java.io.Serializable;

import com.matheus.crm.entity.Product;
import com.matheus.crm.entity.Supplier;

public class ProductDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Long id;
    public String name;
    public String description;
    public double price;
    public String imgUrl;
    public int sku;
    public Supplier supplier;
    
    
    public ProductDTO(Product entity) {
    	this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
		this.sku = entity.getSku();
		this.supplier = entity.getSupplier();
    }
    
	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, String description, double price, String imgUrl, int sku,
			Supplier supplier) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.sku = sku;
		this.supplier = supplier;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
    
    
}
