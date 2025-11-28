package com.marlonviado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.marlonviado.entity.AccountTypes;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountTypes,Integer> {

}
