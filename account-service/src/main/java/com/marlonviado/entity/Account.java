package com.marlonviado.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.marlonviado.annotation.ValidEmail;
import com.marlonviado.enums.AccountType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "CUSTOMER_NUMBER",
			nullable = false)
	private String customerNumber;
	
	@Column(name = "CUSTOMER_NAME",
			nullable = false)
	private String customerName;
	
	@Column(name = "CUSTOMER_MOBILE",
			nullable = false)
	private String customerMobile;
	
	@NotNull
	@ValidEmail(message = "Email is required field")
	@Column(name = "CUSTOMER_EMAIL",
			nullable = false)
	private String customerEmail;
	
	@Column(name = "ADDRESS1",
			nullable = false)
	private String address1;
	
	@Column(name = "ADDRESS2",
			nullable = true)
	private String address2;
	
	@Column(name = "ACCOUNT_TYPE",
			nullable = false)
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	@OneToMany(
			mappedBy = "account", 
			cascade = CascadeType.ALL
			)
	private List<AccountTypes> accountTypes;
	
}
