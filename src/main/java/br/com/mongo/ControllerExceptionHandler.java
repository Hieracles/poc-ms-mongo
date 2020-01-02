package br.com.mongo;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotAuthorizedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.mongo.dto.Erro;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	@ExceptionHandler
	protected ResponseEntity<Erro> handleBadRequest(NotFoundException e){
		
		LOGGER.warn(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Erro(e.getMessage()));
		
	}
	
	@ExceptionHandler
	protected ResponseEntity<Erro> handleBadRequest(BadRequestException e){
		
		LOGGER.warn(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Erro(e.getMessage()));

	}
	
	@ExceptionHandler
	protected ResponseEntity<Erro> handleHttpClientErrorException(HttpClientErrorException e) {
		
		LOGGER.warn(e.getMessage(), e);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Erro(e.getMessage()));
		
	}
		
	@ExceptionHandler
	protected ResponseEntity<Erro> handleInterServerErrorRequest(RuntimeException e) {
		
		LOGGER.error("Erro tratado: " + e.getMessage(), e);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Erro("Ocorreu um erro na execução da API. Contate o administrador"));
		
	}
	
	@ExceptionHandler
	protected ResponseEntity<Erro> handleInterServerErrorRequest(ConstraintViolationException e) {
		
		LOGGER.error("Erro tratado: " + e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Erro(e.getMessage()));
		
	}
	
	@ExceptionHandler
	protected ResponseEntity<Erro> handleIOExceptionRequest(IOException e) {
		
		LOGGER.error(e.getMessage(), e);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Erro("Ocorreu um erro na execução da API. Contate o administrador"));
		
	}
	
	@ExceptionHandler
	protected ResponseEntity<Erro> handleNotAuthorizaException(NotAuthorizedException e) {
		
		LOGGER.warn(e.getMessage(), e);
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Erro(e.getMessage()));
		
	}
	
	@ExceptionHandler
	protected ResponseEntity<Erro> handleTimeoutExceptionException(TimeoutException e) {
		
		LOGGER.warn(e.getMessage(), e);
		
		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new Erro(e.getMessage()));
		
	}
	
	
	

}
