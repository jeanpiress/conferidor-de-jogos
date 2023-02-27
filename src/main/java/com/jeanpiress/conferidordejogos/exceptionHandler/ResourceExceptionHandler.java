package com.jeanpiress.conferidordejogos.exceptionHandler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError error = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		
		return ResponseEntity.status(status).body(error);
		
	}
	
	@ExceptionHandler(ResourceNotNullException.class)
	public ResponseEntity<StandarError> resourceNotNull(ResourceNotNullException e, HttpServletRequest request){
		String erro = "Nome, email e senha não podem ser vazios";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError error = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		
		return ResponseEntity.status(status).body(error);
		
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandarError> database(DatabaseException e, HttpServletRequest request){
		String erro = "Database erro";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError error = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		
		return ResponseEntity.status(status).body(error);
		
	}
	
}
