package com.keonics.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "batch")
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "batch_name")
	private String batch_name;
	
	@Column(name = "start_date")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date start_date;
	
	@Column(name = "end_date")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date end_date;
	
	@OneToOne
	private Course course;
	
	@OneToOne
	private Center center;
	
	@OneToMany
	private List<Student> students;
	
	public Batch() {
	
	}

	public Batch(String batch_name, Date start_date, Date end_date, Course course, Center center,
			List<Student> students) {
		super();
		this.batch_name = batch_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.course = course;
		this.center = center;
		this.students = students;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatch_name() {
		return batch_name;
	}

	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

}
