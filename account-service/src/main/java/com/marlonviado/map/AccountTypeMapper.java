package com.marlonviado.map;

import com.marlonviado.dto.AccountTypeDTO;
import com.marlonviado.entity.AccountTypes;

public class AccountTypeMapper {
	
	public static AccountTypes mapToEntity(AccountTypeDTO accountTypeDTO) {
		return AccountTypes.builder()
				.customerNumber(accountTypeDTO.getCustomerNumber())
				.accountNumber(accountTypeDTO.getAccountNumber())
				.accountTypes(accountTypeDTO.getAccountTypes())
				.availableBalance(accountTypeDTO.getAvailableBalance())
				.build();
	}
	
	public static AccountTypeDTO mapToAccountDTO(AccountTypes accountType) {
		return AccountTypeDTO.builder()
				.accountNumber(accountType.getAccountNumber())
				.accountTypes(accountType.getAccountTypes())
				.availableBalance(accountType.getAvailableBalance())
				.build();
	}


}
