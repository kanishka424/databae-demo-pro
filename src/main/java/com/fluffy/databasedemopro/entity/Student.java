package com.fluffy.databasedemopro.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToOne(fetch=FetchType.LAZY)//how to say this is a LAZY fetch,then no more joins with PASSPORT table
    private Passport passport;

   @ManyToMany
   @JoinTable(name="STUDENT_COURSE",//this is in the owning side of the relationship
   joinColumns =@JoinColumn(name="STUDENT_ID"),
   inverseJoinColumns = @JoinColumn(name="COURSE_ID"))//how to change default join table names
   private List<Course> courses=new ArrayList<>();

    protected Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourses(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course){
        courses.remove(course);

    }



    @Override
    public String toString() {
        return String.format("Student[%s]", name);
    }
}


//=====================ref======================================
//@ManyToMany-084 Step 35 - ManyToMany Mapping - Adding Annotations on Entities
////how to change default join table and columns names-086 Step 37 - ManyToMany Mapping - Customizing the Join Table