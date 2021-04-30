package com.keonics.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.entity.Center;
import com.keonics.modal.CenterDao;
import com.keonics.services.CenterService;

@Service
public class CenterServiceImp implements CenterService {

	private CenterDao centerDao;
	
	@Autowired
	public CenterServiceImp(CenterDao centerDao) {
		
		this.centerDao = centerDao;	
		
	}
	
	@Override
	@Transactional
	public List<Center> getCenters() {
		
		return centerDao.getCenters();
	
	}

	
	@Override
	@Transactional
	public Center addCenter(Center center) {
		
		return centerDao.addCenter(center);
		
	}

	@Override
	@Transactional
	public Center delete(int id) {
		
		return centerDao.delete(id);
		
	}

	@Override
	public List<Center> getCenters(int id) {
		
		return centerDao.getCenters(id);
	}
}
