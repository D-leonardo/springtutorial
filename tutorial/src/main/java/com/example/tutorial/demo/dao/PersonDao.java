/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.example.tutorial.demo.dao;
import com.example.tutorial.demo.model.Person;
import java.util.List;
import java.util.Optional;

import java.util.UUID;

/**
 *
 * @author LEONARDO
 */
public interface PersonDao {
    int insertPerson(UUID id, Person person);
    
    default int insertPerson(Person person){
        UUID id=UUID.randomUUID();
        return insertPerson(id,person);
    }
    
    List<Person> selectAllPeaple();

    Optional<Person> selectPersonById(UUID id);
    
    int deletePersonById(UUID id);
    
    int updatePersonById(UUID id,Person person);
    

}
