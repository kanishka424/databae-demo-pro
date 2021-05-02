package com.fluffy.databasedemopro.repository;

import com.fluffy.databasedemopro.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository//to let know it's a repository
@Transactional//this is to work methods as transactions

public class CourseRepository {
    @Autowired
    EntityManager entityManager;//what we need in a JPA repo to communicate with database

    public Course findById(Long id){
      return   entityManager.find(Course.class,id);//(the return type,primary key)
    }

    public void deleteById(Long id){
        Course course=findById(id);
        entityManager.remove(course);
    }


    public Course save(Course course){//for both insert() and update()
        if(course.getId()==null){
            entityManager.persist(course);//to insert
        }else{
            entityManager.merge(course);//to update
        }
        return course;
    }

    public void playWithEntityManager(){
//        Course course=new Course("web services in 100 steps");
//        entityManager.persist(course);
//        course.setName("web services in 100 steps-updated");//we don't need "entityManager.persist(course);" after this, because of "@Transactional"
//        //this is recognized as a transaction and EM keeps track of things (modification ) and persist to database automatically.See datbase after  running it


//        Course course1=new Course("web services in 100 steps");
//       entityManager.persist(course1);
//       entityManager.flush();
//
//
//        Course course2=new Course("React in 100 steps");
//        entityManager.persist(course2);
//        entityManager.flush();
//
//
//        Course course3=new Course("Angular in 100 steps");
//        entityManager.persist(course3);
//        entityManager.flush();//track and persist everything until this
//
//
//        entityManager.detach(course1);//untrack specfied entity (
//        course1.setName("web services in 100 steps-updated");
//
//
//        //entityManager.clear();//untrack all entities after this
//
//        course2.setName("React in 100 steps-updated");
//        course3.setName("Angular in 100 steps-updated");
//               entityManager.refresh(course3);


//        Course course=new Course("web services in 100 steps");
//        course.setName(null);
//        entityManager.persist(course);
//        entityManager.flush();


        Course course1=new Course("web services in 100 steps");
       entityManager.persist(course1);
       entityManager.flush();

      Course course2=findById(1003L);
      course2.setName("JPA 52-updated");


    }

}

//=========================NOTE===============================
//we don't need @Transactional for findById() but for delete() we need it since it makes a change
//in save() persist-insert merge-update

//flush()-everything uptil this is persisted
//detach(course)-the course entity is detached from here afterwards the changes won't be tracked
//clear()-same as detach() but happens to every object rather than one particular object



//========================ref===================
//deleteById(int id),@Transactional-050 Step 06 - Writing a deleteByID method to delete an Entity
//save  save(Course course)-052 Step 08 - Writing a save method to update and insert an Entity