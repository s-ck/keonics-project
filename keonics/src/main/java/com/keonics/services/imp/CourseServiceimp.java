package com.keonics.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.entity.Course;
import com.keonics.modal.imp.CourseDaoimp;
import com.keonics.services.CourseService;

@Service
public class CourseServiceimp implements CourseService {

	private CourseDaoimp courseDaoimp;
	
	@Autowired
	public CourseServiceimp(CourseDaoimp courseDaoimp) {
		
		this.courseDaoimp = courseDaoimp;
	}
	
	@Override
	@Transactional
	public List<Course> getAllcourse() {
		
		return courseDaoimp.getAllcourse();
	}

	@Override
	@Transactional
	public Course getCourseById(int id) {
	
		return courseDaoimp.getCourseById(id);
		
	}

	@Override
	@Transactional
	public Course save(Course course) {
		
		return courseDaoimp.save(course);
		
	}

	@Override
	@Transactional
	public Course delete(int id) {
		
		return courseDaoimp.delete(id);
		
	}

}
