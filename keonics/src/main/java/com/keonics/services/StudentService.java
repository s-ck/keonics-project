package com.keonics.services;

import java.util.List;

import com.keonics.entity.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public List<Student> getAllStudents(int id);
	
	public Student addStudent(Student student);
	
	public Student delete(int id);
}
