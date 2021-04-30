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
import org.springframework.web.bind.annotation.RestController;

import com.keonics.entity.Course;
import com.keonics.services.imp.CourseServiceimp;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {

	private CourseServiceimp courseServiceimp;
	
	@Autowired
	public CourseController(CourseServiceimp courseServiceimp) {
		
		this.courseServiceimp = courseServiceimp;
		
	}
	
	@GetMapping("/courseList")
	public List<Course> getAllcourse(){
		
		return courseServiceimp.getAllcourse();
		
	}
	
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		
		return courseServiceimp.save(course);
		
	}
	
	@GetMapping("/getCourse/{id}")
	public Course getCourseById(@PathVariable int id) {
		
		return courseServiceimp.getCourseById(id);
		
	}
	
	@DeleteMapping("/deleteCourse/{id}")
	public Course delete(@PathVariable int id) {
		
		return courseServiceimp.delete(id);
		
	}
}
