package com.jeanpiress.conferidordejogos.exceptionHandler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotNullException.class)
	public ResponseEntity<StandarError> resourceNotnull(ResourceNotNullException e, HttpServletRequest request){
		String erro = "Nome, email e senha não podem ser vazios";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError error = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		
		return ResponseEntity.status(status).body(error);
		
	}
	
}
