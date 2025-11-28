package com.marlonviado.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ACCOUNT_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "CUSTOMER_NUMBER",
			nullable = false)
	private String customerNumber;
	@Column(name = "ACCOUNT_NUMBER",
			nullable = false)
	private String accountNumber;
	@Column(name = "ACCOUNT_TYPES",
			nullable = false)
	private String accountTypes;
	@Column(name = "AVAILABLE_BALANCE",
			nullable = false)
	private double availableBalance;
	@ManyToOne(
			fetch = FetchType.LAZY, 
			optional = false
			)
    @JoinColumn(name = "ACCOUNT_ID")
	@JsonProperty(
			access = JsonProperty.Access.WRITE_ONLY
			)
	private Account account;
	
}
