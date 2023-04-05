package com.jeanpiress.conferidordejogos.exceptionHandler;

public class UsuarioRepetidoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UsuarioRepetidoException() {
	super("Email já cadastrado");
}
	
}
