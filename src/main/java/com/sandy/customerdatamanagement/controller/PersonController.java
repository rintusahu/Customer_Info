package com.sandy.customerdatamanagement.controller;

import com.sandy.customerdatamanagement.entity.PersonEntity;
import com.sandy.customerdatamanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping(value = "/person")
    public @ResponseBody PersonEntity saveDetails(@RequestBody PersonEntity person){
        return service.saveDetails(person);
    }
    @PutMapping(value = "/person")
    public @ResponseBody PersonEntity updatePerson(@RequestBody PersonEntity person){
        return service.updatePerson(person);
    }
    @GetMapping(value = "/person/{id}")
    public PersonEntity getPersonDataById(@PathVariable("id") Integer id ){
        return service.getDataById(id);
    }
    @DeleteMapping(value = "/person")
    public @ResponseBody PersonEntity deletePersonDataById(@RequestParam("id") Integer id){
        return service.deletePersonDataById(id);
    }
}
