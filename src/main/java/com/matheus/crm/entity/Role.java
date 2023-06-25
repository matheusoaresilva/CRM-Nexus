package com.matheus.crm.entity;


import com.matheus.crm.entity.enums.LevelAccess;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority, Serializable {
	private static final long serialVersionUID = 1L;

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  @Enumerated(EnumType.STRING)
	  @Column(nullable = false)
	  private LevelAccess roleName;

	@Override
	public String getAuthority() {
		return this.getRoleName().toString();
	}

	  public Role() {
		}

	public Role(Long id, LevelAccess roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Role(Long id) {
	    this.id = id;
	  }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LevelAccess getRoleName() {
		return roleName;
	}

	public void setRoleName(LevelAccess roleName) {
		this.roleName = roleName;
	}
}
