package com.devsuperior.dscommerce.controllers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

import com.devsuperior.dscommerce.dto.CustomError;
import com.devsuperior.dscommerce.services.exceptions.DatabaseException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
@ExceptionHandler(ResourceAccessException.class)
public ResponseEntity<CustomError> resourceNotFound(ResourceAccessException e, HttpServletRequest request) {
HttpStatus status = HttpStatus.NOT_FOUND;
CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
return ResponseEntity.status(status).body(err);
 
 }
@ExceptionHandler(DatabaseException.class)
public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) {
HttpStatus status = HttpStatus.BAD_REQUEST;
CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
return ResponseEntity.status(status).body(err);
 
 }
}
