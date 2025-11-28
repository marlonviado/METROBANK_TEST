package com.marlonviado.enums;

public enum AccountType {
	
	S("Savings"),
	C("Checking");

	private final String description;

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
		throw new IllegalArgumentException("No Account Type found with description: " + description);
	}
	
}
