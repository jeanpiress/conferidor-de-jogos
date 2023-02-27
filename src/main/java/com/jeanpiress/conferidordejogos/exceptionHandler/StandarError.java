package com.jeanpiress.conferidordejogos.exceptionHandler;

import java.io.Serializable;
import java.time.Instant;

public class StandarError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String erro;
	private String mensagem;
	private String path;
	
	public StandarError() {
		
	}
	
	public StandarError(Instant timestamp, Integer status, String erro, String mensagem, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
