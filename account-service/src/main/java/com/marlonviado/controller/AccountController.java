package com.marlonviado.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.marlonviado.dto.AccountDTO;
import com.marlonviado.entity.Account;
import com.marlonviado.entity.AccountTypes;
import com.marlonviado.request.Request;
import com.marlonviado.response.Response;
import com.marlonviado.service.AccountService;
import com.marlonviado.validator.ValidEmailValidator;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<AccountDTO>> createAccount(@RequestBody @Valid Request request) {

		ValidEmailValidator email = new ValidEmailValidator();
		
		if(!email.isValid(request.getRequest().getCustomerEmail(), null)) {
			log.error("Error Email format!");
			return ResponseEntity
                    .badRequest()
                    .body(Response.<AccountDTO>builder()
                			.customerNumber(null)
                			.transactionStatusCode(HttpStatus.BAD_REQUEST.value())
                			.transactionStatusDescription("Email is required field".toUpperCase())
                			.build());
		}

		AccountDTO account = accountService
				.saveAccount(request.getRequest());
		account.setAccountType(null);
		account.setAddress1(null);
		account.setAddress2(null);
		account.setCustomerEmail(null);
		account.setCustomerMobile(null);
		account.setCustomerName(null);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(Response.<AccountDTO>builder()
				.customerNumber(account.getCustomerNumber())
				.transactionStatusCode(HttpStatus.CREATED.value())
				.transactionStatusDescription("Customer account".toUpperCase() + " " + HttpStatus.CREATED.name())
				.build());
	}
	
	@GetMapping("/{customerNumber}")
	public ResponseEntity<Response<Account>> getCustomerNumber(@PathVariable String customerNumber) {
		Optional<Account> account = accountService.getCustomerNumber(customerNumber);
		if(!account.isPresent()) {
			return ((BodyBuilder) ResponseEntity
                    .notFound())
                    .body(Response.<Account>builder()
                			.transactionStatusCode(HttpStatus.NOT_FOUND.value())
                			.transactionStatusDescription("Customer not found".toUpperCase())
                			.build());
		}
		Account acc = account.get();
		
		// We don't need to display customer number, so clear it 
		List<AccountTypes> accountTypes = acc.getAccountTypes();
		accountTypes.stream().forEach(acnt -> {
			acnt.setCustomerNumber(null);
		});
		
		acc.setAccountType(null);
		return ResponseEntity.status(HttpStatus.FOUND).body(Response.<Account>builder()
				.response(account.get())
				.transactionStatusCode(HttpStatus.FOUND.value())
				.transactionStatusDescription("Customer account".toUpperCase() + " " + HttpStatus.FOUND.name())
				.build());
	}

}
