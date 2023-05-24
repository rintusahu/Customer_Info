package com.sandy.customerdatamanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandy.customerdatamanagement.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

	List<CustomerEntity> findByName(String name);
	
	@Query("SELECT c FROM CustomerEntity c WHERE c.name=:name AND c.email=:email")
	List<CustomerEntity> validateCustomer(@Param("name") String name, @Param ("email") String email);
	
}
