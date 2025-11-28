package com.marlonviado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerNotFoundException extends NullPointerException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
