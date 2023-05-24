package com.sandy.customerdatamanagement.controller;

import java.util.List;

import com.sandy.customerdatamanagement.dto.CustomerDto;
import com.sandy.customerdatamanagement.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandy.customerdatamanagement.entity.CustomerEntity;
import com.sandy.customerdatamanagement.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/customer")
	public @ResponseBody ResponseStructure<CustomerEntity> saveCustomer(@RequestBody CustomerDto dto) {
		return service.saveCustomer(dto);
	}
	
	@PutMapping("/customer")
	public @ResponseBody ResponseStructure<CustomerEntity> updateCustomer(@RequestBody CustomerEntity customer) {
		//return service.updateCustomer(customer);
		return service.updateCustomer(customer);
	}
	
	@GetMapping(value="/customer")
	public  @ResponseBody ResponseStructure<List<CustomerEntity>> getAllCustomer() {
		
//		return service.getAllCustomer();
		return service.getAllCustomer();
	}
	
	@GetMapping(value="/customer/{id}")
	public CustomerEntity getCustomerDataById(@PathVariable ("id") Integer id) {
		return service.getDataById(id);
	}
	
	@DeleteMapping(value="/customer")
	public  @ResponseBody CustomerEntity deleteCustomerDataById(@RequestParam("id") Integer id) {
		return service.deleteCustomerDataById(id);
	}
	
	@GetMapping (value="/customerbyname/{name}")
	 public @ResponseBody List<CustomerEntity> getCustomerByName(@PathVariable("name") String name) {
	    	return service.getCustomerByName(name);
	    }
	@PostMapping(value="validatecustomer")
	public List<CustomerEntity> validateCustomer(@RequestParam("name") String name,@RequestParam("email") String email){
		return service.validateCustomer(name, email);
	}
	
}
