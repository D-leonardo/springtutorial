/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tutorial.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
/**
 *
 * @author LEONARDO
 */
public class Person {

    private final UUID id;
    
    @NotBlank
    private final String name;

    public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
 
}
