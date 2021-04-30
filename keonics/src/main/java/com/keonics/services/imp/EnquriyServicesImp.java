package com.keonics.services.imp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.entity.Course;
import com.keonics.entity.Enquiry;
import com.keonics.modal.EnquiryDao;
import com.keonics.services.EnquiryServices;

@Service
public class EnquriyServicesImp implements EnquiryServices{

	private EnquiryDao enquiryDao;

	@Autowired
	public EnquriyServicesImp(EnquiryDao enquiryDao) {
		
		this.enquiryDao = enquiryDao;
		
	}
	
	@Override
	@Transactional
	public List<Enquiry> getAllenquiry() {
		return enquiryDao.getAllenquiry();
	}
	
	@Override
	@Transactional
	public List<Enquiry> getAllenquiry(int id) {
		return enquiryDao.getAllenquiry(id);
	}

	@Override
	@Transactional
	public Enquiry getEnquirybyId(int id) {
		
		return enquiryDao.getEnquirybyId(id);
	}

	@Override
	@Transactional
	public Enquiry save(Enquiry enquiry, List<Course> courses) throws Exception{
		
		return enquiryDao.save(enquiry, courses);
	}

	@Override
	@Transactional
	public Enquiry delete(int id) {
		
		return enquiryDao.delete(id);
		
	}

	
}
