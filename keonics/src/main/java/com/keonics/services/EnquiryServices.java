package com.keonics.services;

import java.util.List;
import java.util.Set;

import com.keonics.entity.Course;
import com.keonics.entity.Enquiry;

public interface EnquiryServices {
	
	public List<Enquiry> getAllenquiry();
	
	public List<Enquiry> getAllenquiry(int id);
	
	public Enquiry getEnquirybyId(int id);
	
	public Enquiry save(Enquiry enquiry, List<Course> courses) throws Exception;
	
	public Enquiry delete(int id);
	
}
