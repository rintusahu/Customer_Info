package com.sandy.customerdatamanagement.repository;

import com.sandy.customerdatamanagement.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankEntity,Integer> {

}
