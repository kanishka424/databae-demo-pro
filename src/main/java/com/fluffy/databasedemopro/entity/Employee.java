package com.fluffy.databasedemopro.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity//@Entity is a specilization of @Bean//@MappedSuperclass and Entity can't be used at the same time
//@Inheritance(strategy =InheritanceType.SINGLE_TABLE )//how to defining INHERITANCE entity mapping relationship to tables,if we don't add by default it is SINGLE_TABLE
//@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS )
//@Inheritance(strategy =InheritanceType.JOINED )
//@MappedSuperclass//@MappedSuperclass and Entity can't be used at the same time
@DiscriminatorColumn(name="Employee Type")//we just give "DTYPE"(this is an autogenerated column for SINGLE_TABLE ) column a name
public abstract class  Employee {
    @Id//the primary  key
    @GeneratedValue//lets JPA decide the id
    private Long id;
    // @Column(name="fullname",nullable = false)
    @Column(nullable = false)//there are other properties as well
    private String name;




    protected Employee() {

    }


    public Employee(String name) {
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
    public String toString() {
        return String.format("Employee name is" + name + " and id is " + id);
    }


}
//===================NOTE==================
//options for mapping entites with table
//1.SINGLE_TABLE
//2.TABLE_PER_CLASS
//3.JOINED
//4.@MappedSuperclass// when this is applies there cant be @Entity so no Employee entity so we also can't query the Employee table


//======================ref=========================
//first created in-092 Step 43 - JPA Inheritance Hierarchies and Mappings - Setting up entities