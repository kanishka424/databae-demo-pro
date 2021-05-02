package com.fluffy.databasedemopro;

import com.fluffy.databasedemopro.entity.Course;
import com.fluffy.databasedemopro.entity.Review;
import com.fluffy.databasedemopro.entity.Student;
import com.fluffy.databasedemopro.repository.CourseRepository;
import com.fluffy.databasedemopro.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DatabaseDemoProApplication  implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoProApplication.class, args);


	}

	@Autowired
	CourseRepository courseRepository;


	@Autowired
	StudentRepository studentRepository;

	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {


		studentRepository.saveStudentAndCourse(new Student("Jake"),new Course("MS in 100 steps"));
		List<Review> reviews=new ArrayList<>();

		reviews.add(new Review("5","Excellent"));
		reviews.add(new Review("5","Hats Off"));
		studentRepository.saveStudentWithPassport();
		courseRepository.addReviewForCourse(1003L,reviews);



//		Course course=courseRepository.findById(1001L);
//		logger.info("findBY "+course);
//
//		courseRepository.deleteById(1002L);
//
//		courseRepository.save(new Course("to test save-persist"));
//
//		courseRepository.playWithEntityManager();
	}




}

