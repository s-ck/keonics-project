package com.keonics.modal;

import java.util.List;

import com.keonics.entity.Student;

public interface StudentDao {

	public List<Student> getAllStudents();
	
	public List<Student> getAllStudents(int id);
	
	public Student addStudent(Student student);
	
	public Student delete(int id);
}
