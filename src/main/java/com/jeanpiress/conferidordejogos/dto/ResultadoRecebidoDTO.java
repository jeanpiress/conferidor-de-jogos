package com.jeanpiress.conferidordejogos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.entities.Usuario;

public class ResultadoRecebidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	private Long numeroConcurso;
	private List<String> list = new ArrayList<>();
	

	
	
	
	public ResultadoRecebidoDTO() {
		
	}



	public ResultadoRecebidoDTO(Long numeroConcurso, List<String> list) {
		super();
		
		this.numeroConcurso = numeroConcurso;
		this.list = list;
		
	}




	public Long getNumeroConcurso() {
		return numeroConcurso;
	}



	public void setNumeroConcurso(Long numeroConcurso) {
		this.numeroConcurso = numeroConcurso;
	}



	public List<String> getList() {
		return list;
	}



	public void setList(List<String> list) {
		this.list = list;
	}



	
    
}
