/*
package com.jeanpiress.conferidordejogos.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aposta")
public class Aposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name = "jogo_id")
	private Jogo jogo;
	
	
	
	public Aposta() {
		
	}

	public Aposta(Long id, Integer numero, Jogo jogo) {
		super();
		this.id = id;
		this.numero = numero;
		this.jogo = jogo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Jogo getJogo() {
		return jogo;
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
		Aposta other = (Aposta) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
*/