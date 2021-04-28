package com.fluffy.databasedemopro;

import com.fluffy.databasedemopro.entity.Course;
import com.fluffy.databasedemopro.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseDemoProApplication  implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoProApplication.class, args);


	}

	@Autowired
	CourseRepository courseRepository;
	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {
		Course course=courseRepository.findById(1001);
		logger.info("findBY "+course);
	}

}

