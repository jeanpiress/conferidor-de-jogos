package com.jeanpiress.conferidordejogos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_resultadoFinal")
public class ResultadoFinal implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long idJogo;
	private Long concurso;
	private Integer acerto1;
	private Integer acerto2;
	private Integer acerto3;
	private Integer acerto4;
	private Integer acerto5;
	private Integer acerto6;
	private Integer acerto7;
	private Integer acerto8;
	private Integer acerto9;
	private Integer acerto10;
	private Integer acerto11;
	private Integer acerto12;
	private Integer acerto13;
	private Integer acerto14;
	private Integer acerto15;
	private Integer acerto16;
	private Integer acerto17;
	private Integer acerto18;
	private Integer acerto19;
	private Integer acerto20;
	
	
	
	private Integer acertosTotais;
	
	private Long usuario;
	
	public ResultadoFinal() {
		
	}
	
	public ResultadoFinal(Long id, Long idJogo, Long concurso, Integer acerto1, Integer acerto2, Integer acerto3, Integer acerto4,
			Integer acerto5, Integer acerto6, Integer acerto7, Integer acerto8, Integer acerto9, Integer acerto10,
			Integer acerto11, Integer acerto12, Integer acerto13, Integer acerto14, Integer acerto15, Integer acerto16, Integer acerto17,
			Integer acerto18, Integer acerto19, Integer acerto20, Integer acertosTotais, Long usuario) {
		super();
		this.id = id;
		this.idJogo = idJogo;
		this.concurso = concurso;
		this.acerto1 = acerto1;
		this.acerto2 = acerto2;
		this.acerto3 = acerto3;
		this.acerto4 = acerto4;
		this.acerto5 = acerto5;
		this.acerto6 = acerto6;
		this.acerto7 = acerto7;
		this.acerto8 = acerto8;
		this.acerto9 = acerto9;
		this.acerto10 = acerto10;
		this.acerto11 = acerto11;
		this.acerto12 = acerto12;
		this.acerto13 = acerto13;
		this.acerto14 = acerto14;
		this.acerto15 = acerto15;
		this.acerto16 = acerto16;
		this.acerto17 = acerto17;
		this.acerto18 = acerto18;
		this.acerto19 = acerto19;
		this.acerto20 = acerto20;
		this.acertosTotais = acertosTotais;
		this.usuario = usuario;
	}

	
	public void setIdJogo(Long idJogo) {
		this.idJogo = idJogo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConcurso() {
		return concurso;
	}

	public void setConcurso(Long concurso) {
		this.concurso = concurso;
	}

	public Integer getAcerto1() {
		return acerto1;
	}

	public void setAcerto1(Integer acerto1) {
		this.acerto1 = acerto1;
	}

	public Integer getAcerto2() {
		return acerto2;
	}

	public void setAcerto2(Integer acerto2) {
		this.acerto2 = acerto2;
	}

	public Integer getAcerto3() {
		return acerto3;
	}

	public void setAcerto3(Integer acerto3) {
		this.acerto3 = acerto3;
	}

	public Integer getAcerto4() {
		return acerto4;
	}

	public void setAcerto4(Integer acerto4) {
		this.acerto4 = acerto4;
	}

	public Integer getAcerto5() {
		return acerto5;
	}

	public void setAcerto5(Integer acerto5) {
		this.acerto5 = acerto5;
	}

	public Integer getAcerto6() {
		return acerto6;
	}

	public void setAcerto6(Integer acerto6) {
		this.acerto6 = acerto6;
	}

	public Integer getAcerto7() {
		return acerto7;
	}

	public void setAcerto7(Integer acerto7) {
		this.acerto7 = acerto7;
	}

	public Integer getAcerto8() {
		return acerto8;
	}

	public void setAcerto8(Integer acerto8) {
		this.acerto8 = acerto8;
	}

	public Integer getAcerto9() {
		return acerto9;
	}

	public void setAcerto9(Integer acerto9) {
		this.acerto9 = acerto9;
	}

	public Integer getAcerto10() {
		return acerto10;
	}

	public void setAcerto10(Integer acerto10) {
		this.acerto10 = acerto10;
	}

	public Integer getAcerto11() {
		return acerto11;
	}

	public void setAcerto11(Integer acerto11) {
		this.acerto11 = acerto11;
	}

	public Integer getAcerto12() {
		return acerto12;
	}

	public void setAcerto12(Integer acerto12) {
		this.acerto12 = acerto12;
	}

	public Integer getAcerto13() {
		return acerto13;
	}

	public void setAcerto13(Integer acerto13) {
		this.acerto13 = acerto13;
	}

	public Integer getAcerto14() {
		return acerto14;
	}

	public void setAcerto14(Integer acerto14) {
		this.acerto14 = acerto14;
	}

	public Integer getAcerto15() {
		return acerto15;
	}

	public void setAcerto15(Integer acerto15) {
		this.acerto15 = acerto15;
	}

	
	public Integer getAcerto16() {
		return acerto16;
	}

	public void setAcerto16(Integer acerto16) {
		this.acerto16 = acerto16;
	}

	public Integer getAcerto17() {
		return acerto17;
	}

	public void setAcerto17(Integer acerto17) {
		this.acerto17 = acerto17;
	}

	public Integer getAcerto18() {
		return acerto18;
	}

	public void setAcerto18(Integer acerto18) {
		this.acerto18 = acerto18;
	}

	public Integer getAcerto19() {
		return acerto19;
	}

	public void setAcerto19(Integer acerto19) {
		this.acerto19 = acerto19;
	}

	public Integer getAcerto20() {
		return acerto20;
	}

	public void setAcerto20(Integer acerto20) {
		this.acerto20 = acerto20;
	}

	public Long getIdJogo() {
		return idJogo;
	}

	public Integer getAcertosTotais() {
		return acertosTotais;
	}

	public void setAcertosTotais(Integer acertosTotais) {
		this.acertosTotais = acertosTotais;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
	

	

	






}
