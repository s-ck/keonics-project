package com.keonics.modal;

import java.util.List;

import com.keonics.entity.Course;

public interface CourseDao {

	public List<Course> getAllcourse();
	
	public Course getCourseById(int id);
	
	public Course save(Course course);
	
	public Course delete(int id);
}
