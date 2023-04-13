package com.jeanpiress.conferidordejogos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jeanpiress.conferidordejogos.entities.Jogo;

public class JogoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Long numeroConcurso;
	private List<Integer> list = new ArrayList<>();
	
	private String usuario;
	
	public Long numerosJogados;
	
	public JogoDTO() {
		
	}
	
	public JogoDTO(Jogo obj) {
		id = obj.getId();
		numeroConcurso = obj.getNumeroConcurso();
		
		list.addAll(Arrays.asList(obj.getPrimeiro(), obj.getSegundo(), obj.getTerceiro(),
		obj.getQuarto(), obj.getQuinto(), obj.getSexto(), obj.getSetimo(), obj.getOitavo(), obj.getNono(),
		obj.getDecimo(), obj.getDPrimeiro(), obj.getDSegundo(), obj.getDTerceiro(), obj.getDQuarto(), obj.getDQuinto(),
		obj.getDSexto(), obj.getDSetimo(), obj.getDOitavo(), obj.getDNono(), 
		obj.getVigesimo()));
		
		list = list.stream().filter(x -> x != null).collect(Collectors.toList());
		
		numerosJogados = list.stream().count();
		
		if(obj.getUsuario() != null) {
		usuario = obj.getUsuario().getNome();
		}
		
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

	public Long getNumerosJogados() {
		return numerosJogados;
	}
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	
    
}
