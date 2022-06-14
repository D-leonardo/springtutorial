/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tutorial.demo.dao;

import com.example.tutorial.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LEONARDO
 */
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao  {
    
    private static List<Person> DB = new ArrayList<>();
    
    @Override
    public int insertPerson(UUID id,Person person){
           DB.add(new Person(id,person.getName()));
           return 1;
    }

    public FakePersonDataAccessService() {
    }
    
    @Override
    public List<Person> selectAllPeaple(){
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person->person.getId().equals(id)).findFirst();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deletePersonById(UUID id) {
        
        Optional<Person> personMaybe =selectPersonById(id);
        
        if(!personMaybe.isPresent()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id).map(person ->{
            int indexOfPersonToDelet=DB.indexOf(person);
            if(indexOfPersonToDelet>=0){
                DB.set(indexOfPersonToDelet,new Person(id,update.getName()));
                return 1;
            }
            return 0;
        }).orElse(0); 
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
