package com.marlonviado.enums;

import java.util.Arrays;

public enum AccountType {
	
	S("Savings"),
	C("Checking");

	private String description;
	
	AccountType() {
		this.description="Savings";
	}

	AccountType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static AccountType fromDescription(String description) {
		for (AccountType type : AccountType.values()) {
			if (type.getDescription().equalsIgnoreCase(description)) {
				return type;
			}
		}
		return S;
	}
	
	// Check if account type is valid
	public static boolean contains(String value) {
		return Arrays.stream(AccountType.values())
		.anyMatch(accountType -> accountType.name().equalsIgnoreCase(value));
	}
	
}
