package com.jeanpiress.conferidordejogos.exceptionHandler;

public class ResourceNotNullException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotNullException() {
		super("Operação invalida");
	}
}
