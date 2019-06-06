package com.prudutos.apirest.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.boot.convert.Delimiter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prudutos.apirest.errors.ResourceNotFoundDetails;
import com.prudutos.apirest.errors.ResourceNotFoundException;
import com.prudutos.apirest.errors.ValidationErrorDetails;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException mavnException){
		List<FieldError> fieldErrors= mavnException.getBindingResult().getFieldErrors();
		
		String fields =fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldMessages= fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		ValidationErrorDetails rnfDetais = ValidationErrorDetails.Builder
				.newBuilder()
				.timestamp(new Date().getTime())
                .title("Field Validation Error")
                .detail("Field Validation Error")
                .status(HttpStatus.BAD_REQUEST.value())
                .developerMessage(mavnException.getClass().getName())
                .field(fields)
                .fieldMessage(fieldMessages)
                .build();
		return new ResponseEntity<>(rnfDetais,HttpStatus.BAD_REQUEST);
	}
	
	//fazer a parte generica para todos erros (aula 14)

}
