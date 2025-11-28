package com.marlonviado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import com.marlonviado.dto.AccountDTO;
import com.marlonviado.entity.Account;
import com.marlonviado.entity.AccountTypes;
import com.marlonviado.map.AccountMapper;
import com.marlonviado.repository.AccountRepository;
import com.marlonviado.repository.AccountTypeRepository;
import com.marlonviado.util.NumberUtil;
import jakarta.transaction.Transactional;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountTypeRepository accountTypeRepository;
	
	
	@Transactional
	@Modifying
	public AccountDTO saveAccount(AccountDTO accountDTO) {

		String customerNo = NumberUtil
				.generateCustomerNumber(8);
		accountDTO.setCustomerNumber(customerNo);

		String accountNo = NumberUtil
				.generateCustomerNumber(6);
		
		String types = accountDTO.getAccountType()
				.getDescription()=="Savings" ? "Savings" : "Checking";
		
		Account account = AccountMapper
				.mapToEntity(accountDTO);
		
		AccountTypes accountTypes = AccountTypes.builder()
				.account(account)
				.customerNumber(customerNo)
				.accountNumber(accountNo)
				.accountTypes(types)
				.availableBalance(500.00)
				.build();
		
		List<AccountTypes> listAccountTypes = new ArrayList<>();
		listAccountTypes.add(accountTypes);

		account.setAccountTypes(listAccountTypes);
		
		accountDTO.setAccountTypes(listAccountTypes);
		
		AccountDTO accDTO = AccountMapper
				.mapToAccountDTO(accountRepository.save(account));
		
		accountTypeRepository.saveAll(listAccountTypes);
		
		return accDTO;
	}
	
	public Optional<Account> getCustomerNumber(String customerNumber) {
		return accountRepository.getCustomerNumber(customerNumber);
	}

}
