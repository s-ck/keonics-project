package com.keonics.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.modal.Count;
import com.keonics.services.CountService;

@Service
public class CountServiceimp implements CountService{

	private Count count;
	
	@Autowired
	public CountServiceimp(Count count) {
		this.count = count;
	}
	
	@Override
	@Transactional
	public int getCenterCount() {
		return count.getCenterCount();
	}

	@Override
	@Transactional
	public int getEnquiryCount() {
		return count.getEnquiryCount();
	}

	@Override
	@Transactional
	public int getBatchCount() {
		return count.getBatchCount();
	}

	@Override
	@Transactional
	public int getPaymentsCount() {
		return count.getPaymentsCount();
	}

	@Override
	@Transactional
	public int getStudentCount() {
		return count.getStudentCount();
	}

	@Override
	@Transactional
	public int getCertificationCount() {
		return count.getCertificationCount();
	}

}
