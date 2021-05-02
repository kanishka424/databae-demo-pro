package com.fluffy.databasedemopro.repository;

import com.fluffy.databasedemopro.DatabaseDemoProApplication;
import com.fluffy.databasedemopro.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes = DatabaseDemoProApplication.class)
public class JPQLTest {

    @Autowired
    EntityManager entityManager;

    Logger logger= LoggerFactory.getLogger(this.getClass());


    @Test
    public void jpql_Basic() {
        Query query=entityManager.createNamedQuery("query_get_all_courses");//theses are named queries in Course.jav//createQuery() was replaced with createNamedQuery
        List resultList=query.getResultList();
        logger.info("basic",resultList);
    }
    @Test
    public void jpqlTyped_Basic() {
       TypedQuery<Course> query=entityManager.createNamedQuery("query_get_all_courses",Course.class);//theses are named queries in Course.jav
        List<Course> resultList=query.getResultList();
        logger.info("typed",resultList);
    }

    @Test
    public void jpqlWhere_Basic() {
        TypedQuery<Course> query=entityManager.createNamedQuery("query_get_100_steps_courses",Course.class);//theses are named queries in Course.jav
        List<Course> resultList=query.getResultList();
        logger.info("where",resultList);
    }




}



//======================NOTE===========================
//jpql query entities instead of tables unlike sql
//createQuery(jpql)-how we create a query,when we  provide direct JQL
//createNamedQuery()-when we provide a named query
//getResultList()-how we execute query