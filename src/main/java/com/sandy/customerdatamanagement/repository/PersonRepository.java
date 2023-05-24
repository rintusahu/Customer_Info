package com.sandy.customerdatamanagement.repository;

import com.sandy.customerdatamanagement.entity.BankEntity;
import com.sandy.customerdatamanagement.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
     BankEntity save(BankEntity entity);
}
