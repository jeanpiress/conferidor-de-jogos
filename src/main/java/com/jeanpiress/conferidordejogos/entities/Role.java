package com.jeanpiress.conferidordejogos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.jeanpiress.conferidordejogos.enums.RoleName;

@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority, Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RoleName roleName;
	
	@ManyToMany(mappedBy = "roles")
	List<Usuario> usuarios = new ArrayList<>();
	
	
	@Override
	public String getAuthority() {
		return this.roleName.toString();
	}


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public RoleName getRoleName() {
		return roleName;
	}


	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
