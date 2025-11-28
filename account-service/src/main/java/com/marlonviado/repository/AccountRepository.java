package com.marlonviado.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.marlonviado.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

	@Query("SELECT acc FROM Account acc WHERE acc.customerNumber = ?1")
	Optional<Account> getCustomerNumber(String customerNumber);

}
