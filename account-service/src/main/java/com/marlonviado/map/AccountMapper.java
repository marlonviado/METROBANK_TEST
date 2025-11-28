package com.marlonviado.map;

import com.marlonviado.dto.AccountDTO;
import com.marlonviado.entity.Account;

public class AccountMapper {
	
	public static Account mapToEntity(AccountDTO accountDTO) {
		return Account.builder()
				.customerNumber(accountDTO.getCustomerNumber())
				.customerName(accountDTO.getCustomerName())
				.customerEmail(accountDTO.getCustomerEmail())
				.address1(accountDTO.getAddress1())
				.address2(accountDTO.getAddress2())
				.customerMobile(accountDTO.getCustomerMobile())
				.accountType(accountDTO.getAccountType())
				.build();
	}
	
	public static AccountDTO mapToAccountDTO(Account account) {
		return AccountDTO.builder()
				.address1(account.getAddress1())
				.address2(account.getAddress2())
				.customerEmail(account.getCustomerEmail())
				.customerMobile(account.getCustomerMobile())
				.customerName(account.getCustomerName())
				.customerNumber(account.getCustomerNumber())
				.accountType(account.getAccountType())
				.build();
	}

}
