package com.sandy.customerdatamanagement.service;

import com.sandy.customerdatamanagement.entity.PersonEntity;
import com.sandy.customerdatamanagement.repository.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonDao dao;
    public PersonEntity saveDetails(PersonEntity person){
        return dao.saveDetails(person);
    }
    public PersonEntity updatePerson(PersonEntity person){
        return dao.saveDetails(person);
    }
    public PersonEntity getDataById(int id){
        return dao.getPersonDataById(id);
    }
    public PersonEntity deletePersonDataById(int id){
        return dao.deleteCustomerById(id);
    }
}
