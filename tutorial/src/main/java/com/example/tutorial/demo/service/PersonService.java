/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tutorial.demo.service;
import com.example.tutorial.demo.dao.PersonDao;
import com.example.tutorial.demo.model.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author LEONARDO
 */
@Service
public class PersonService {
    
    private final PersonDao personDao;
    
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao=personDao;
    }
    
    public int addPerson(Person person){     
        return personDao.insertPerson(person);
    }
    
    public List<Person> getAllPeaple(){
        return personDao.selectAllPeaple();
    }
    
    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
    
    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }
    
    public int updatePerson(UUID id, Person person){
        return personDao.updatePersonById(id, person);
    }
    
}
