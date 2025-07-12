package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.exception.StudentErrorResponse;
import com.example.demo.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("A", "B", "C"));
		theStudents.add(new Student("AA", "BB", "CC"));
		return theStudents;
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {

		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("A", "B", "C"));
		theStudents.add(new Student("AA", "BB", "CC"));

		if (id >= 0 && id < theStudents.size()) {
			Student student = theStudents.get(id);
			return student;
		} else {
			throw new StudentNotFoundException("Student ID not found - " + id);
		}
	}
}
