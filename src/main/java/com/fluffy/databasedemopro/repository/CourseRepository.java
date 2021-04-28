package com.fluffy.databasedemopro.repository;

import com.fluffy.databasedemopro.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository//to let know it's a repository
public class CourseRepository {
    @Autowired
    EntityManager entityManager;//what we need in a JPA repo to communicate with database

    public Course findById(int id){
      return   entityManager.find(Course.class,id);//(the return type,primary key)
    }

}
