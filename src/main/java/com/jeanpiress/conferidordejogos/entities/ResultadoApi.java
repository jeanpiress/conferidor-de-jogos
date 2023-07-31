package com.jeanpiress.conferidordejogos.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ResultadoApi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long numero_concurso;
	private List<String> dezenas;
	
	public ResultadoApi() {
		
	}
	
	public ResultadoApi(Long numero_concurso, List<String> dezenas) {
		super();
		this.numero_concurso = numero_concurso;
		this.dezenas = dezenas;
	}

	public Long getNumero_concurso() {
		return numero_concurso;
	}

	public void setNumero_concurso(Long numero_concurso) {
		this.numero_concurso = numero_concurso;
	}

	public List<String> getDezenas() {
		return dezenas;
	}

	public void setDezenas(List<String> dezenas) {
		this.dezenas = dezenas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero_concurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadoApi other = (ResultadoApi) obj;
		return Objects.equals(numero_concurso, other.numero_concurso);
	}
	
	

}
