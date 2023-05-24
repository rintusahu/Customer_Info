package com.sandy.customerdatamanagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.sandy.customerdatamanagement.entity.CustomerEntity;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository repository;
	
    public CustomerEntity saveCustomer(CustomerEntity customer) {
    	
    	return repository.save(customer);
    }
    
    public List<CustomerEntity> getAllCustomer() {

		return repository.findAll();
    }
    
    
    public CustomerEntity getCustomerDataById(int id) {
    	return repository.findById(id).orElse(new CustomerEntity(HttpStatus.NOT_FOUND.value(),
    			HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
    }
    
    public CustomerEntity deleteCustomerById(int id) {
    	 CustomerEntity customerDataById = getCustomerDataById(id);
    	 
    	 if (customerDataById.getId()!=404) {
    		 repository.deleteById(id);
    	 }
    	 return customerDataById;
    }
    
    public List<CustomerEntity> getCustomerByName(String name) {
    	return repository.findByName(name);
    }
    
    public List<CustomerEntity> validateCustomer(String name, String email) {
    	return repository.validateCustomer(name, email);
    }

}
