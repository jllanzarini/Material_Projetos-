package com.example.projetoweb_t.exception;

import java.util.Date;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.example.projetoweb_t.exception.ErrorDetails;

@ControllerAdvice
public class globalExceptionHandler {
	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globaleExcpetionHandler(Exception ex, WebRequest request) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
