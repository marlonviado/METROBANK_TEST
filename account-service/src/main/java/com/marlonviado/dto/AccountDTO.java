package com.marlonviado.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.marlonviado.entity.Account;
import com.marlonviado.entity.AccountTypes;
import com.marlonviado.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountDTO {
	
	private int id;
	private String customerNumber;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String address1;
	private String address2;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private List<AccountTypes> accountTypes;
	
	public AccountDTO(Account account) {
		this.id=account.getId();
		this.customerNumber=account.getCustomerNumber();
		this.customerName=account.getCustomerName();
		this.customerMobile=account.getCustomerMobile();
		this.customerEmail=account.getCustomerEmail();
		this.address1=account.getAddress1();
		this.address2=account.getAddress2();
		this.accountType=account.getAccountType();
		this.accountTypes=account.getAccountTypes();

	}
	
}
