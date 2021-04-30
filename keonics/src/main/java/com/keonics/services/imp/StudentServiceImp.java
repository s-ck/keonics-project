package com.keonics.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.entity.Student;
import com.keonics.modal.StudentDao;
import com.keonics.services.StudentService;

@Service
public class StudentServiceImp implements StudentService {

	private StudentDao studentDao;
	
	@Autowired
	public StudentServiceImp(StudentDao studentDao) {
		
		this.studentDao = studentDao;
		
	}
	
	@Override
	@Transactional
	public List<Student> getAllStudents() {
			
		return studentDao.getAllStudents();
		
	}
	
	@Override
	@Transactional
	public List<Student> getAllStudents(int id) {
			
		return studentDao.getAllStudents(id);
		
	}

	@Override
	@Transactional
	public Student addStudent(Student student) {
		
		return studentDao.addStudent(student);
		
	}

	@Override
	@Transactional
	public Student delete(int id) {
		
		return studentDao.delete(id);
		
	}
}
