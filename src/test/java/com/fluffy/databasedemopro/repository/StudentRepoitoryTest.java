package com.fluffy.databasedemopro.repository;

import com.fluffy.databasedemopro.DatabaseDemoProApplication;
import com.fluffy.databasedemopro.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest(classes =DatabaseDemoProApplication.class)
class CourseRepoitoryTest {

	@Autowired
	CourseRepository courseRepository;




	@Test
	public void findByIdBasic() {
		Course course=courseRepository.findById(1001L);

		assertEquals("JPA 50",course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteByIdBasic(){
		courseRepository.deleteById(1003L);
		assertNull(courseRepository.findById(1003L));
	}

	@Test
	public void findByIdBasic2() {//this will passs because of  @DirtiesContext  in deleteByIdBasic(),data is restored
		Course course=courseRepository.findById(1003L);

		assertEquals("JPA 50",course.getName());
	}



	@Test
	@DirtiesContext
	public void save_basic() {
		// get a course
		Course course = courseRepository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");
		courseRepository.save(course);

		// check the value
		Course course1 = courseRepository.findById(10001L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}


	@Test
	@DirtiesContext
	public void playWithEntityManager(){
		courseRepository.playWithEntityManager();
	}



}


//==================NOTE=======================
//the basic test case for findById()
//to get the structure use  DatabaseDemoProApplicationTests
//@RunWith


//@DirtiesContext-is needed to restore data as before running the test (for methods like deleteByIdBasic())

//===================ref============================
//	@DirtiesContext,deleteByIdBasic,assertNull()-051 Step 07 - Writing Unit Test for deleteById method

//save_basic() -053 Step 09 - Writing Unit Test for save method