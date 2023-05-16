package com.jeanpiress.conferidordejogos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jeanpiress.conferidordejogos.entities.Resultado;

public class ResultadosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Long numeroConcurso;
	private List<Integer> list = new ArrayList<>();
	
	
	
	
	public ResultadosDTO() {
		
	}
	
	public ResultadosDTO(Resultado obj) {
		id = obj.getId();
		numeroConcurso = obj.getNumeroConcurso();
		
		list.addAll(Arrays.asList(obj.getPrimeiroR(), obj.getSegundoR(), obj.getTerceiroR(), obj.getQuartoR(), obj.getQuintoR(), obj.getSextoR(),
				obj.getSetimoR(), obj.getOitavoR(), obj.getNonoR(), obj.getdPrimeiroR(), obj.getdSegundoR(), obj.getdTerceiroR(), obj.getdQuartoR(),
				obj.getdQuintoR()));
		
		
		
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



	
	
    
}
