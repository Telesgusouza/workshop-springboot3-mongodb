package com.gustavo.workshop.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gustavo.workshop.resources.exception.StandardError;

import jakarta.servlet.http.HttpServletRequest;

/*
 
 indica que sera para tratar erros
  
 */

@ControllerAdvice
public class ResourceExceptionHandler {
	
	/*
	  
	 System.currentTimeMillis() = pega o estante do erro
	 
	 isso diz que tipo de erro ele é, no caso um documento não encontrado (not found)

	 descrição curt do erro
	 
	 mensagem
	 
	 caminho do erro
	 */
	
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
