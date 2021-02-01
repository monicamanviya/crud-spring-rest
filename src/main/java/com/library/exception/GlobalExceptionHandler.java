package com.library.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class GlobalExceptionHandler {
	public GlobalExceptionHandler() {

	}

	// handle specific exception
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		ErrorDetails error = new ErrorDetails("NOT_FOUND_ERROR", e.getMessage(), LocalDateTime.now());
		error.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}


//	// global exception
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception e) {

		ErrorDetails error = new ErrorDetails("INTERNAL_SERVER_ERROR", e.getMessage(), LocalDateTime.now());
		error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
