package com.marlonviado.exception;

import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends ConstraintViolationException {

	public BadRequestException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public BadRequestException(String message, Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(message, constraintViolations);
		// TODO Auto-generated constructor stub
	}

}
