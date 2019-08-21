package com.andersonmadeira.seapass.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Void> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
		logger.error(ex.getMessage());
		ex.printStackTrace();
		return ResponseEntity.notFound().build();
	}
	
}