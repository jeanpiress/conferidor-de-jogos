package com.jeanpiress.conferidordejogos.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_resultado")
public class Resultado implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long numeroConcurso;
	@NotNull
	private Integer primeiroR;
	@NotNull
	private Integer segundoR;
	@NotNull
	private Integer terceiroR;
	@NotNull
	private Integer quartoR;
	@NotNull
	private Integer quintoR;
	@NotNull
	private Integer sextoR;
	@NotNull
	private Integer setimoR;
	@NotNull
	private Integer oitavoR;
	@NotNull
	private Integer nonoR;
	@NotNull
	private Integer decimoR;
	@NotNull
	private Integer dPrimeiroR;
	@NotNull
	private Integer dSegundoR;
	@NotNull
	private Integer dTerceiroR;
	@NotNull
	private Integer dQuartoR;
	@NotNull
	private Integer dQuintoR;
	
		
	public Resultado() {
		
	}
	
	public Resultado(Long id, Long numeroConcurso, Integer primeiroR, Integer segundoR, Integer terceiroR, Integer quartoR, Integer quintoR, Integer sextoR,
			Integer setimoR, Integer oitavoR, Integer nonoR, Integer decimoR, Integer dPrimeiroR, Integer dSegundoR, Integer dTerceiroR, Integer dQuartoR,
			Integer dQuintoR) {
		super();
		this.id = id;
		this.numeroConcurso = numeroConcurso;
		this.primeiroR = primeiroR;
		this.segundoR = segundoR;
		this.terceiroR = terceiroR;
		this.quartoR = quartoR;
		this.quintoR = quintoR;
		this.sextoR = sextoR;
		this.setimoR = setimoR;
		this.oitavoR = oitavoR;
		this.nonoR = nonoR;
		this.decimoR = decimoR;
		this.dPrimeiroR = dPrimeiroR;
		this.dSegundoR = dSegundoR;
		this.dTerceiroR = dTerceiroR;
		this.dQuartoR = dQuartoR;
		this.dQuintoR = dQuintoR;
	}
	

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroConcurso() {
		return numeroConcurso;
	}


	public void setNumeroConcurso(Long numeroConcurso) {
		this.numeroConcurso = numeroConcurso;
	}


	public Integer getPrimeiroR() {
		return primeiroR;
	}




	public void setPrimeiroR(Integer primeiroR) {
		this.primeiroR = primeiroR;
	}




	public Integer getSegundoR() {
		return segundoR;
	}




	public void setSegundoR(Integer segundoR) {
		this.segundoR = segundoR;
	}




	public Integer getTerceiroR() {
		return terceiroR;
	}




	public void setTerceiroR(Integer terceiroR) {
		this.terceiroR = terceiroR;
	}




	public Integer getQuartoR() {
		return quartoR;
	}




	public void setQuartoR(Integer quartoR) {
		this.quartoR = quartoR;
	}




	public Integer getQuintoR() {
		return quintoR;
	}




	public void setQuintoR(Integer quintoR) {
		this.quintoR = quintoR;
	}




	public Integer getSextoR() {
		return sextoR;
	}




	public void setSextoR(Integer sextoR) {
		this.sextoR = sextoR;
	}




	public Integer getSetimoR() {
		return setimoR;
	}




	public void setSetimoR(Integer setimoR) {
		this.setimoR = setimoR;
	}




	public Integer getOitavoR() {
		return oitavoR;
	}




	public void setOitavoR(Integer oitavoR) {
		this.oitavoR = oitavoR;
	}




	public Integer getNonoR() {
		return nonoR;
	}




	public void setNonoR(Integer nonoR) {
		this.nonoR = nonoR;
	}




	public Integer getDecimoR() {
		return decimoR;
	}




	public void setDecimoR(Integer decimoR) {
		this.decimoR = decimoR;
	}




	public Integer getdPrimeiroR() {
		return dPrimeiroR;
	}




	public void setdPrimeiroR(Integer dPrimeiroR) {
		this.dPrimeiroR = dPrimeiroR;
	}




	public Integer getdSegundoR() {
		return dSegundoR;
	}




	public void setdSegundoR(Integer dSegundoR) {
		this.dSegundoR = dSegundoR;
	}




	public Integer getdTerceiroR() {
		return dTerceiroR;
	}




	public void setdTerceiroR(Integer dTerceiroR) {
		this.dTerceiroR = dTerceiroR;
	}




	public Integer getdQuartoR() {
		return dQuartoR;
	}




	public void setdQuartoR(Integer dQuartoR) {
		this.dQuartoR = dQuartoR;
	}




	public Integer getdQuintoR() {
		return dQuintoR;
	}




	public void setdQuintoR(Integer dQuintoR) {
		this.dQuintoR = dQuintoR;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Resultado other = (Resultado) obj;
		return Objects.equals(id, other.id);
	}

	
}
