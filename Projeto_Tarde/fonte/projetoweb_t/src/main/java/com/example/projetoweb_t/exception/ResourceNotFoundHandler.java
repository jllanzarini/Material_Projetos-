package com.example.projetoweb_t.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundHandler extends Exception {
	private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}