package com.web.spring.web;

import com.web.spring.web.entity.Student;
import com.web.spring.web.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	/*@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		Student student = new Student("Rizky","Yananda", "yanandarizky@gmail.com");
		studentRepository.save(student);

	}*/
}
