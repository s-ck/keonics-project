package com.keonics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keonics.entity.Student;
import com.keonics.services.StudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		
		this.studentService = studentService;
		
	} 
	
	@GetMapping("/listStudents")
	public List<Student> getAllStudents(){
		
		return studentService.getAllStudents();
	}
	
	@GetMapping("/listStudents/{id}")
	public List<Student> getAllStudents(@PathVariable int id){
		
		return studentService.getAllStudents(id);
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		
		return studentService.addStudent(student);
		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public Student delete(@PathVariable int id) {
		
		return studentService.delete(id);
		
	}
}
