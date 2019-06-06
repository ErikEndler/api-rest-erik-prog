package com.prudutos.apirest.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prudutos.apirest.errors.ResourceNotFoundDetails;
import com.prudutos.apirest.errors.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rfnException){
		ResourceNotFoundDetails rnfDetais = ResourceNotFoundDetails.builder()
				.withTimestamp(new Date().getTime())
                .withTitle("Resource not found")
                .withDetail(rfnException.getMessage())
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withDeveloperMessage(rfnException.getClass().getName())
                .build();
		return new ResponseEntity<>(rnfDetais,HttpStatus.NOT_FOUND);
	}

}
