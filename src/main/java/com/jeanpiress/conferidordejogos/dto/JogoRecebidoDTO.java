package com.jeanpiress.conferidordejogos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jeanpiress.conferidordejogos.entities.Jogo;
import com.jeanpiress.conferidordejogos.entities.Usuario;

public class JogoRecebidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Long numeroConcurso;
	private List<String> list = new ArrayList<>();
	
	private Usuario usuario;
	
	
	
	public JogoRecebidoDTO() {
		
	}



	public JogoRecebidoDTO(Long id, Long numeroConcurso, List<String> list, Jogo obj) {
		super();
		this.id = id;
		this.numeroConcurso = numeroConcurso;
		this.list = list;
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



	public List<String> getList() {
		return list;
	}



	public void setList(List<String> list) {
		this.list = list;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
    
}
