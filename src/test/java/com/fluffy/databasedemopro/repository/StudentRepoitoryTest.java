package com.fluffy.databasedemopro.repository;

import com.fluffy.databasedemopro.DatabaseDemoProApplication;
import com.fluffy.databasedemopro.entity.Passport;
import com.fluffy.databasedemopro.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes =DatabaseDemoProApplication.class)
class StudentRepoitoryTest {


	Logger logger= LoggerFactory.getLogger(this.getClass());



@Autowired
EntityManager entityManager;

@Autowired
StudentRepository studentRepository;

		@Test
		@Transactional//marks the entire method as one transaction otherwise each statement would a single transaction itself
		public void test(){
			studentRepository.someOperationToUndertandPersistanceContext();
		}


	@Test
	@Transactional//without this transaction would end with findById() but this will keep transaction session till end of method,p.s-see book for further reference*IMPORTANT
	public void retriveStudentAndPassportDetail() {
		Student student= entityManager.find(Student.class,20001L);
		logger.info("Student->{}",student);
		logger.info("passport->{}",student.getPassport());//when hibernate sees this it will go and retrieve data for passport from PASSPORT table*IMPORTANT
		//rather than joining the tables initially THIS IS LAZY FETCHING


	}


	@Test
	@Transactional//without this transaction would end with findById() but this will keep transaction session till end of method,p.s-see book for further reference*IMPORTANT
	public void retrievePassportAndAssociateDetail() {
		Passport passport= entityManager.find(Passport.class,40001L);
		logger.info("Passport->{}",passport);
		logger.info("student->{}",passport.getStudent());//when hibernate sees this it will go and retrieve data for passport from PASSPORT table*IMPORTANT
		//rather than joining the tables initially THIS IS LAZY FETCHING


	}


	@Test
	@Transactional
	public void retrieveStudentAndCourseDetails(){
			Student student=entityManager.find(Student.class,20001L);
			logger.info("Student->{}",student);
			logger.info("Courses->{}",student.getCourses());
	}







}


//==================NOTE=======================
//	1.	"Student student= studentRepository.findById(20001L);"-this  is eager fetch,by default every one to one mapping is an eager fetch,
//which means when you ask for student table you will also get the corresponding passport data VIA a JOIN
//since we did "@OneToOne(fetch=FetchType.LAZY)" in Student.java passport field the above is no longer Eager fetch but a LAzy fetch

//2.logger.info("passport->{}",student.getPassport());//when hibernate sees this it will go and retrieve data for passport from PASSPORT table
//		//rather than joining the tables initially THIS IS LAZY FETCHING


//===================ref============================
//069 Step 25 - OneToOne Mapping - Retrieving Student with Passport and Eager Fetch



//@Transactional
//Perssistence Context
//		EntityManager
//this are well explained in 071 Step 27 - Transaction_ Entity Manager and Persistence Context
