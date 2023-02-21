package com.jeanpiress.conferidordejogos.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pacoteDeJogos")
public class PacoteDeJogos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroConcurso;
		
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public PacoteDeJogos() {
		
	}
	
	public PacoteDeJogos(Long id,String numeroConcurso, Usuario usuario) {
		super();
		this.id = id;
		this.numeroConcurso = numeroConcurso;
		this.usuario = usuario;
	}

	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroConcurso() {
		return numeroConcurso;
	}
	

	public void setNumeroConcurso(String numeroConcurso) {
		this.numeroConcurso = numeroConcurso;
	}
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacoteDeJogos other = (PacoteDeJogos) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
}
