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

	private Integer numerosPrimos;
	private Integer par;
	private Integer impar;
	private List<Integer> numerosRepetidos;
	private List<Integer> numerosNaoRepetidos;

	public ResultadosDTO() {

	}

	public ResultadosDTO(Resultado obj) {
		id = obj.getId();
		numeroConcurso = obj.getNumeroConcurso();

		list.addAll(Arrays.asList(obj.getPrimeiroR(), obj.getSegundoR(), obj.getTerceiroR(), obj.getQuartoR(),
				obj.getQuintoR(), obj.getSextoR(), obj.getSetimoR(), obj.getOitavoR(), obj.getNonoR(), obj.getDecimoR(),
				obj.getdPrimeiroR(), obj.getdSegundoR(), obj.getdTerceiroR(), obj.getdQuartoR(), obj.getdQuintoR()));

		numerosPrimos = contadorPrimos();

		par = contPar();
		
		impar = contImpar();
	
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
	
	

	public Integer getNumerosPrimos() {
		return numerosPrimos;
	}

	public void setNumerosPrimos(Integer numerosPrimos) {
		this.numerosPrimos = numerosPrimos;
	}
	
	
	public Integer getPar() {
		return par;
	}

	public void setPar(Integer par) {
		this.par = par;
	}

	public Integer getImpar() {
		return impar;
	}

	public void setImpar(Integer impar) {
		this.impar = impar;
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

	private Integer contadorPrimos() {
		Integer primos = 0;
		List<Integer> listaPrimos = new ArrayList<>();
		listaPrimos.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23));
		for (Integer p : list) {
			if (listaPrimos.contains(p)) {
				primos++;
			}
		}
		return primos;
	}
	
	private Integer contImpar() {
		impar = 0;
		for(Integer p: list) {
			if(p%2 != 0) {
				impar ++;
			}
		}
		return impar;
	}

	private Integer contPar() {
		par = 0;
		for(Integer p: list) {
			if(p%2 == 0) {
				par ++;
			}
		}
		return par;
	}

	

}
