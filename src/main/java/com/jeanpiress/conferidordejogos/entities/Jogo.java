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
@Table(name = "tb_jogos")
public class Jogo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroConcurso;
	
	private Integer primeiro;
	private Integer segundo;
	private Integer terceiro;
	private Integer quarto;
	private Integer quinto;
	private Integer sexto;
	private Integer setimo;
	private Integer oitavo;
	private Integer nono;
	private Integer decimo;
	private Integer DPrimeiro;
	private Integer DSegundo;
	private Integer DTerceiro;
	private Integer DQuarto;
	private Integer DQuinto;
	private Integer DSexto;
	private Integer DSetimo;
	private Integer DOitavo;
	private Integer DNono;
	private Integer Vigesimo;
	
			
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	
	public Jogo() {
		
	}
	
	public Jogo(Long id, Long numeroConcurso, Integer primeiro, Integer segundo, Integer terceiro, Integer quarto,
			Integer quinto, Integer sexto, Integer setimo, Integer oitavo, Integer nono, Integer decimo,
			Integer dPrimeiro, Integer dSegundo, Integer dTerceiro, Integer dQuarto, Integer dQuinto, Integer dSexto,
			Integer dSetimo, Integer dOitavo, Integer dNono, Integer vigesimo, Usuario usuario) {
		
		super();
		this.id = id;
		this.numeroConcurso = numeroConcurso;
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.terceiro = terceiro;
		this.quarto = quarto;
		this.quinto = quinto;
		this.sexto = sexto;
		this.setimo = setimo;
		this.oitavo = oitavo;
		this.nono = nono;
		this.decimo = decimo;
		this.DPrimeiro = dPrimeiro;
		this.DSegundo = dSegundo;
		this.DTerceiro = dTerceiro;
		this.DQuarto = dQuarto;
		this.DQuinto = dQuinto;
		this.DSexto = dSexto;
		this.DSetimo = dSetimo;
		this.DOitavo = dOitavo;
		this.DNono = dNono;
		this.Vigesimo = vigesimo;
		this.usuario = usuario;
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
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	
	
	
	public Integer getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Integer primeiro) {
		this.primeiro = primeiro;
	}

	public Integer getSegundo() {
		return segundo;
	}

	public void setSegundo(Integer segundo) {
		this.segundo = segundo;
	}

	public Integer getTerceiro() {
		return terceiro;
	}

	public void setTerceiro(Integer terceiro) {
		this.terceiro = terceiro;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Integer getQuinto() {
		return quinto;
	}

	public void setQuinto(Integer quinto) {
		this.quinto = quinto;
	}

	public Integer getSexto() {
		return sexto;
	}

	public void setSexto(Integer sexto) {
		this.sexto = sexto;
	}

	public Integer getSetimo() {
		return setimo;
	}

	public void setSetimo(Integer setimo) {
		this.setimo = setimo;
	}

	public Integer getOitavo() {
		return oitavo;
	}

	public void setOitavo(Integer oitavo) {
		this.oitavo = oitavo;
	}

	public Integer getNono() {
		return nono;
	}

	public void setNono(Integer nono) {
		this.nono = nono;
	}

	public Integer getDecimo() {
		return decimo;
	}

	public void setDecimo(Integer decimo) {
		this.decimo = decimo;
	}

	public Integer getDPrimeiro() {
		return DPrimeiro;
	}

	public void setDPrimeiro(Integer dPrimeiro) {
		DPrimeiro = dPrimeiro;
	}

	public Integer getDSegundo() {
		return DSegundo;
	}

	public void setDSegundo(Integer dSegundo) {
		DSegundo = dSegundo;
	}

	public Integer getDTerceiro() {
		return DTerceiro;
	}

	public void setDTerceiro(Integer dTerceiro) {
		DTerceiro = dTerceiro;
	}

	public Integer getDQuarto() {
		return DQuarto;
	}

	public void setDQuarto(Integer dQuarto) {
		DQuarto = dQuarto;
	}

	public Integer getDQuinto() {
		return DQuinto;
	}

	public void setDQuinto(Integer dQuinto) {
		DQuinto = dQuinto;
	}

	public Integer getDSexto() {
		return DSexto;
	}

	public void setDSexto(Integer dSexto) {
		DSexto = dSexto;
	}

	public Integer getDSetimo() {
		return DSetimo;
	}

	public void setDSetimo(Integer dSetimo) {
		DSetimo = dSetimo;
	}

	public Integer getDOitavo() {
		return DOitavo;
	}

	public void setDOitavo(Integer dOitavo) {
		DOitavo = dOitavo;
	}

	public Integer getDNono() {
		return DNono;
	}

	public void setDNono(Integer dNono) {
		DNono = dNono;
	}

	public Integer getVigesimo() {
		return Vigesimo;
	}

	public void setVigesimo(Integer vigesimo) {
		Vigesimo = vigesimo;
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
		Jogo other = (Jogo) obj;
		return Objects.equals(id, other.id);
	}

	

	
	}

	


	
	
	

