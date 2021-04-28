package com.fluffy.databasedemopro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//@Entity is a specilization of @Bean
public class Course {
    @Id//the primary  key
    @GeneratedValue//lets JPA decide the id
    private int id;
    private String name;

    protected Course (){

    }

    public Course(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
      return String.format("Course name is"+ name +" and id is "+id)  ;
    }
}
