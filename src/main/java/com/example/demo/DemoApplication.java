package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//		return runner -> {
//			System.out.println("Command Line Runner");
//			createStudent(studentDAO);
//			findStudent(studentDAO);
//			deleteStudent(studentDAO);
//		};
//	}
//
//	private void createStudent(StudentDAO studentDAO) {
//		System.out.println("Inside Create Method");
//		Student student = new Student("ABC", "PQR", "XYZ");
//
//		studentDAO.save(student);
//		System.out.println("Saved = " + student.getId());
//	}
//
//	private void findStudent(StudentDAO studentDAO) {
//		System.out.println("Inside Find Method");
//		Student student = studentDAO.findById(2);
//		System.out.println("Student fetched = " + student);
//	}
//	
//	private void deleteStudent(StudentDAO studentDAO) {
//		System.out.println("Inside Delete  Method");
//		//studentDAO.delete(2);
//	}


}

