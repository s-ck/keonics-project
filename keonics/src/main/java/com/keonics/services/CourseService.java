package com.keonics.services;

import java.util.List;

import com.keonics.entity.Course;

public interface CourseService {

	public List<Course> getAllcourse();
	
	public Course getCourseById(int id);
	
	public Course save(Course course);
	
	public Course delete(int id);
	
}
