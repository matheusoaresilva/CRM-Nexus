package com.matheus.crm.entity;

import java.io.Serializable; 

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

import com.matheus.crm.entity.enums.LevelAccess;
import com.matheus.crm.entity.enums.StatusProfile;

@Table(name = "seller")
@Entity(name = "seller")
public class Seller implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
    private String name;
	
	@Column
    private String phone;
	
	@Column
    private String email;
	
	@Column
    private String cpf;
	
	@OneToOne
	@JoinColumn(name = "address_id")
    private Address address;
	
	@Column
    private Double commission;
	
	@Enumerated(EnumType.ORDINAL)
	@Column
    private StatusProfile statusProfile;
	
	@Enumerated(EnumType.ORDINAL)
	@Column
    private LevelAccess levelAccess;
	
//    private ArrayList<Sale> sales = new ArrayList<>();
    
    public Seller() {
	}
    
    public Seller(Seller entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.phone = entity.getPhone();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.address = entity.getAddress();
		this.commission = entity.getCommission();
		this.statusProfile = entity.getStatusProfile();
		this.levelAccess = entity.getLevelAccess();
	}
    
    public Seller(Long id, String name, String phone, String email, String cpf, Address address, Double commission,
			StatusProfile statusProfile, LevelAccess levelAccess) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.cpf = cpf;
		this.address = address;
		this.commission = commission;
		this.statusProfile = statusProfile;
		this.levelAccess = levelAccess;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public StatusProfile getStatusProfile() {
		return statusProfile;
	}
	public void setStatusProfile(StatusProfile statusProfile) {
		this.statusProfile = statusProfile;
	}
	public LevelAccess getLevelAccess() {
		return levelAccess;
	}
	public void setLevelAccess(LevelAccess levelAccess) {
		this.levelAccess = levelAccess;
	}
    
    
}
