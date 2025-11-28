package com.marlonviado.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.marlonviado.response.Response;
import jakarta.validation.ConstraintViolationException;
import com.marlonviado.exception.BadRequestException;
import com.marlonviado.exception.CustomerNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(BadRequestException.class)
	public Response<?> emailException(BadRequestException ex) {
		
		Response<?> orderResponse = new Response<>();
		orderResponse.setTransactionStatusCode(HttpStatus.BAD_REQUEST.value());
		orderResponse.setTransactionStatusDescription("Email is required field");
		
		if(orderResponse.getTransactionStatusCode()==HttpStatus.BAD_REQUEST.value()) {
			throw new ConstraintViolationException("Bad Request",null);
		}
		
		return orderResponse;
		
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public Response<?> customerNotFoundException(CustomerNotFoundException ex) {
		Response<?> orderResponse = new Response<>();
		orderResponse.setTransactionStatusCode(HttpStatus.NOT_FOUND.value());
		orderResponse.setTransactionStatusDescription("Customer not found");
		
		return orderResponse;
	}

}
