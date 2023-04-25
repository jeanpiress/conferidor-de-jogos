package com.jeanpiress.conferidordejogos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jeanpiress.conferidordejogos.entities.ResultadoFinal;

public class FinaisDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Long numeroConcurso;
	private List<Integer> list = new ArrayList<>();
	
    
	
	public Integer acertos;
	private Long usuario;
	
	public FinaisDTO() {
		
	}
	
	public FinaisDTO(ResultadoFinal obj) {
		id = obj.getIdJogo();
		numeroConcurso = obj.getConcurso();
		
		list.addAll(Arrays.asList(obj.getAcerto1(), obj.getAcerto2(), obj.getAcerto3(), obj.getAcerto4(), obj.getAcerto5(), 
				obj.getAcerto6(), obj.getAcerto7(), obj.getAcerto8(), obj.getAcerto9(), obj.getAcerto10(), obj.getAcerto11(),
				obj.getAcerto12(), obj.getAcerto13(), obj.getAcerto14(), obj.getAcerto15()));
		
		list = list.stream().filter(x -> x != null).collect(Collectors.toList());
		
		acertos = obj.getAcertosTotais();
		
		usuario = obj.getUsuario();
		
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

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Integer getAcertos() {
		return acertos;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	



	
	
    
}
