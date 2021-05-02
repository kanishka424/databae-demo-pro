package com.fluffy.databasedemopro.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch=FetchType.LAZY,mappedBy = "passport")//mappedBy makes Student entity own the relationship,so no student_id column is created in STUDENT table
    private Student student;

    protected Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}

//==========================NOTE======================
//here we have annotated @OneToOne on "student" to make it Bi-directional but then comes data duplication,as a solution we have introduced "mappedBy"



//====================ref===================
//for bi-directional mapping and mappedBy-072 Step 28 - OneToOne Mapping - Bidirectional Relationship - Part 1