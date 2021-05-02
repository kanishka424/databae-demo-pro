package com.fluffy.databasedemopro.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity//@Entity is a specilization of @Bean
//@Table(name="CourseDetail")//1.this will create table named COURSE_DETAIL 2.if you don't need default name "Course" for table
@NamedQueries(value={//how to name queries and use it
       @NamedQuery(name="query_get_all_courses",query="select c from Course c"),
        @NamedQuery(name="query_get_100_steps_courses",query="select c from Course c where name like '%100 step'")

})
public class Course {
    @Id//the primary  key
    @GeneratedValue//lets JPA decide the id
    private Long id;
   // @Column(name="fullname",nullable = false)
   @Column(nullable = false)//there are other properties as well
    private String name;

   @UpdateTimestamp//timestamp when updating
   private LocalDateTime lastUpdateDate;

   @CreationTimestamp//timestamp when creating
   private LocalDateTime createdDate;

   @OneToMany(fetch = FetchType.LAZY,mappedBy="course")//when we use mappedBy in an entity it means it's not owning the relationship
    private List<Review> reviews=new ArrayList<>();//we should initialized it here

    @ManyToMany(mappedBy = "courses")
    private List<Student> students=new ArrayList<>();

    protected Course (){

    }




    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
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


    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review  review) {//here we hava changed the setter method accordingly
        reviews.add(review);
    }

    public boolean removeReview(Review review){//created manually
        return reviews.remove(review);
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        students.add(student);
    }
}



//======================ref=========================
//@NamedQueries-063 Step 19 - JPA and Hibernate Annotations - @NamedQuery and @NamedQueries
//mapped by only applies to realtionships OneToMany ,OneToOne
//@ManyToMany-084 Step 35 - ManyToMany Mapping - Adding Annotations on Entities