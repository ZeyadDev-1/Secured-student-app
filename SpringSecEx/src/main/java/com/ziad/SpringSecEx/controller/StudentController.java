package com.ziad.SpringSecEx.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ziad.SpringSecEx.moudle.Student;


import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	private List<Student> students = new ArrayList<>(List.of(new Student(657,"Ali",99), new Student(449,"Mona",81), new Student(876,"Ahmed",95))) ;
	
	@GetMapping("/students")
	 public List<Student> getAllStudents() {
		 return students;
	 }
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		
			CsrfToken cs =(CsrfToken) request.getAttribute("_csrf");
			return cs;	
	}
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student ){
		students.add(student);
		return student;
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(@RequestBody Student interedStudent) {

	    for (Student student : students) {
	        if (student.equals(interedStudent)) {
	            students.remove(student);
	            return ResponseEntity.ok("Student deleted successfully!");
	        }
	    }
	    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Student not found!");
	}
	
}
