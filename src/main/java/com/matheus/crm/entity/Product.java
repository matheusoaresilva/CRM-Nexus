package com.matheus.crm.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "product")
@Entity(name = "product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Double price;
	@Column
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
    private Category category;
	
	@Column
	private Integer sku;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
    private Supplier supplier;

	public Product() {

	}

	

	public Product(Long id, String name, String description, Double price, String imgUrl, Category category,
			Integer sku, Supplier supplier) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		this.category = category;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}