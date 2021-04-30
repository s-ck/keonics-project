package com.keonics.entity;

import java.util.Date;

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
@Table(name = "payments")
public class Payments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "payment")
	private double payment;
	
	@Column(name = "startdate")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date startdate;
	
	@Column(name = "enddate")
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date enddate;
	
	@OneToOne
	private Center center;

	public Payments() {
	
	}

	public Payments(double payment, Date startdate, Date enddate, Center center) {
		this.payment = payment;
		this.startdate = startdate;
		this.enddate = enddate;
		this.center = center;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public Date getStardate() {
		return startdate;
	}

	public void setStardate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEndate() {
		return enddate;
	}

	public void setEndate(Date enddate) {
		this.enddate = enddate;
	}
}
