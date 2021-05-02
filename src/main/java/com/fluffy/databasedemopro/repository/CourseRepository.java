package com.fluffy.databasedemopro.repository;

import com.fluffy.databasedemopro.entity.Course;
import com.fluffy.databasedemopro.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository//to let know it's a repository
@Transactional//this is to work methods as transactions

public class CourseRepository {
    @Autowired
    EntityManager entityManager;//what we need in a JPA repo to communicate with database

    Logger logger= LoggerFactory.getLogger(this.getClass());


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

   public void addHarcodedReviewForCourse() {
       Course course = findById(1003L);
       logger.info("Course reviews ->{}",course.getReviews());

       Review review1=new Review("5","Great hands off");
       Review review2=new Review("5","Hats off");


        //setting up relationship
       course.addReview(review1);
       review1.setCourse(course);


       course.addReview(review2);
       review2.setCourse(course);

       //save to databe
       entityManager.persist(review1);
       entityManager.persist(review2);


   }

    public void addReviewForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("Course reviews ->{}",course.getReviews());

        for(Review review:reviews){
            //adding relationships
            course.addReview(review);
            review.setCourse(course);


            entityManager.persist(review);
        }

        Review review1=new Review("5","Great hands off");
        Review review2=new Review("5","Hats off");



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



//addReviewForCourse()-080 Step 31 - ManyToOne Mapping - Retrieving and inserting Reviews for Course