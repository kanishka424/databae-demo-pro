package com.fluffy.databasedemopro.repository;

import com.fluffy.databasedemopro.entity.Course;
import com.fluffy.databasedemopro.entity.Passport;
import com.fluffy.databasedemopro.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository//to let know it's a repository
@Transactional//this is to work methods as transactions

public class StudentRepository {
    @Autowired
    EntityManager entityManager;//what we need in a JPA repo to communicate with database

    public Student findById(Long id){
      return   entityManager.find(Student.class,id);//(the return type,primary key)
    }

    public void deleteById(Long id){
        Student student=findById(id);
        entityManager.remove(student);
    }


    public Student save(Student student){//for both insert() and update()
        if(student.getId()==null){
            entityManager.persist(student);//to insert
        }else{
            entityManager.merge(student);//to update
        }
        return student;
    }


    public void someOperationToUndertandPersistanceContext(){//ref-071 Step 27 - Transaction_ Entity Manager and Persistence Context
        //Database operation 1 -Retrieve student
        Student student=entityManager.find(Student.class,20001L);
        //Persistence Context(student)


        //Database Operation 2-Retrieve passport
        Passport passport=student.getPassport();
        //Persitence Context(student,passport)

        //Datbase Operstion 3-update passport
        passport.setNumber("E123456");
        //Persistence Context(student,passport++)

        //Database operation 4-update student
        student.setName("Ranga-updated");
        //Persistence Context(student,passport)


    }

    public void saveStudentWithPassport(){

        Passport passport=new Passport("Z123456");

        entityManager.persist(passport);//here if we didn't save passport first and saved student instead we would get transient error
        //because they have one to one relationship which is owned by student entity

        Student student=new Student("Kim");
        student.setPassport(passport);

        entityManager.persist(student);




    }

    public void saveStudentAndCourse(Student student, Course course){
        student.addCourses(course);
        course.setStudents(student);



        entityManager.persist(student);//doesn't the order matter?shouldn't course be first in order to save to db so student can refer

        entityManager.persist(course);




    }

}

//=========================NOTE===============================



//========================ref=============================
//1.068 Step 24 - OneToOne Mapping - Insert Student with Passport