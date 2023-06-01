package com.jeanpiress.conferidordejogos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jeanpiress.conferidordejogos.entities.Resultado;

public class Constancia implements Serializable {
	private static final long serialVersionUID = 1L;

	
	//private List<ResultadosDTO> list = new ArrayList<>();

	private List<Integer> numerosRepetidos;
	private List<Integer> numerosNaoRepetidos;

	//public MenuDTO() {

	//}

	public Constancia() {
		

		//list.addAll(resultadosDto);

			
       numerosRepetidos = null;
       
       numerosNaoRepetidos = null;
	}

	


	public List<Integer> getNumerosRepetidos() {
		return numerosRepetidos;
	}

	public void setNumerosRepetidos(List<Integer> numerosRepetidos) {
		this.numerosRepetidos = numerosRepetidos;
	}

	public List<Integer> getNumerosNaoRepetidos() {
		return numerosNaoRepetidos;
	}

	public void setNumerosNaoRepetidos(List<Integer> numerosNaoRepetidos) {
		this.numerosNaoRepetidos = numerosNaoRepetidos;
	}

		

}
