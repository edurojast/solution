package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "persona no encontrada")
public class PersonaInfoNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

    public PersonaInfoNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}