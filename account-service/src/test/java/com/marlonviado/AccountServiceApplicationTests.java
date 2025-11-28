package com.marlonviado;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import com.marlonviado.dto.AccountDTO;
import com.marlonviado.entity.Account;
import com.marlonviado.repository.AccountRepository;
import com.marlonviado.repository.AccountTypeRepository;
import com.marlonviado.service.AccountService;

@SpringBootTest
class AccountServiceApplicationTests {
	
	@MockitoBean
	private AccountRepository accountRepository;
	
	@MockitoBean
	private AccountTypeRepository accountTypeRepository;
	
	@MockitoBean
	private AccountService accountService;
	
	@Test
	void contextLoads() {
	}

	
	@Test
	public void testSaveAccount() {
		AccountDTO accountDTO = AccountDTO.builder()
				.address1("Las Pinas City")
				.address2("")
				.customerEmail("mfviado@hotmail.com")
				.customerMobile("09157062309")
				.customerName("Marlon Viado")
				.customerNumber("12345678")
				.build();
		when(accountService.saveAccount(accountDTO)).thenReturn(accountDTO);
		Assertions.assertNotNull(accountDTO);
	}
	
	@Test
	public void testSuccessEmailFormat() {
		AccountDTO accountDTO = AccountDTO.builder()
				.address1("Las Pinas City")
				.address2("")
				.customerEmail("mfviado@hotmail.com")
				.customerMobile("09157062309")
				.customerName("Marlon Viado")
				.customerNumber("12345678")
				.build();
		
		when(accountService.saveAccount(accountDTO)).thenThrow(new RuntimeException("Email is required field"));
		
		RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> accountService.saveAccount(accountDTO));
		Assertions.assertEquals("Email is required field", ex.getMessage());
        verify(accountService, times(1)).saveAccount(accountDTO);
	}
	

	@Test
	public void testFailedEmailFormat() {
		AccountDTO accountDTO = AccountDTO.builder()
				.address1("Las Pinas City")
				.address2("")
				.customerEmail("mfviado.com")
				.customerMobile("09157062309")
				.customerName("Marlon Viado")
				.customerNumber("12345678")
				.build();
		when(accountService.saveAccount(accountDTO)).thenThrow(new RuntimeException("Email is required field"));
		
		RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> accountService.saveAccount(accountDTO));
		Assertions.assertEquals("Email is required field", ex.getMessage());
        verify(accountService, times(1)).saveAccount(accountDTO);
	}

	@Test
	public void testGetCustomerNumber() {
		Optional<Account> account = Optional.ofNullable(Account.builder()
				.address1("Las Pinas City")
				.address2("")
				.customerEmail("mfviado@hotmail.com")
				.customerMobile("09157062309")
				.customerName("Marlon Viado")
				.customerNumber("12345678")
				.build());
		AccountRepository accountRepository = mock(AccountRepository.class);
		when(accountRepository.getCustomerNumber(account.get().getCustomerNumber())).thenReturn(account);

	}
	
	@Test
	public void testFailedGetCustomerNumber() {
		Optional<Account> account = Optional.ofNullable(null);
		AccountRepository accountRepository = mock(AccountRepository.class);
		when(accountRepository.getCustomerNumber("99999999")).thenReturn(account);
		
	}


}
