 package com.sandy.customerdatamanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import com.sandy.customerdatamanagement.dto.CustomerDto;
import com.sandy.customerdatamanagement.dto.ResponseStructure;
import com.sandy.customerdatamanagement.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sandy.customerdatamanagement.entity.CustomerEntity;

 @Service
public class CustomerService {

//	@Autowired
//	private  CustomerRepository repository;
	
	@Autowired
    private CustomerDao dao;
//    
//	public CustomerEntity saveCustomer(CustomerEntity customer) {
//		return repository.save(customer);
//	}
	
	public ResponseStructure<CustomerEntity> saveCustomer(CustomerDto dto) {
		CustomerEntity customer = new CustomerEntity(dto);
		CustomerEntity cus = dao.saveCustomer(customer);
		ResponseStructure<CustomerEntity> rs = new ResponseStructure<>();
		rs.setData(cus);
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage("Data is saved");
		return rs;
	}
	
	public ResponseStructure<CustomerEntity> updateCustomer(CustomerEntity customer) {
		CustomerEntity cus = dao.saveCustomer(customer);
		ResponseStructure<CustomerEntity> rs = new ResponseStructure<>();
		rs.setData(cus);
		rs.setStatusCode(HttpStatus.ACCEPTED.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage(HttpStatus.ACCEPTED.name());
		return rs;
	}
	
	public ResponseStructure<List<CustomerEntity>> getAllCustomer() {
		List<CustomerEntity> list = dao.getAllCustomer();
		ResponseStructure<List<CustomerEntity>> rs = new ResponseStructure<>();
		if (list.size() !=0){
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setData(list);
			rs.setTimeStamp(LocalDateTime.now());
			rs.setMessage("Required Data is Found");
		}
		else {
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			rs.setData(null);
			rs.setTimeStamp(LocalDateTime.now());
			rs.setMessage("No Data is Found");
		}
		return rs;
	}
	
	public CustomerEntity getDataById(int id) {
		return dao.getCustomerDataById(id);
	}
	
	public CustomerEntity deleteCustomerDataById(int id) {
		return dao.deleteCustomerById(id);
	}
	 public List<CustomerEntity> getCustomerByName(String name) {
	    	return dao.getCustomerByName(name);
	    }
	 
	 public List<CustomerEntity> validateCustomer(String name, String email){
		 return dao.validateCustomer(name, email);
	 }
}
