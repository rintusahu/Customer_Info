package com.sandy.customerdatamanagement.repository;


import com.sandy.customerdatamanagement.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
    @Autowired
    private PersonRepository repository;
    public PersonEntity saveDetails(PersonEntity entity){
        return repository.save(entity);
    }
    public PersonEntity getPersonDataById(int id) {
        return repository.findById(id).orElse(new PersonEntity(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.name()));
    }
    public PersonEntity deleteCustomerById(int id) {
        PersonEntity personDataById = getPersonDataById(id);

        if (personDataById.getId()!=404) {
            repository.deleteById(id);
        }
        return personDataById;
    }
}
