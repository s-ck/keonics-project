package com.keonics.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keonics.entity.Batch;
import com.keonics.modal.BatchDao;
import com.keonics.services.BatchService;

@Service
public class BatchServiceImp implements BatchService{

	private BatchDao batchDao;
	
	@Autowired
	public BatchServiceImp(BatchDao batchDao) {
	
		this.batchDao = batchDao;
		
	}
	
	@Override
	@Transactional
	public List<Batch> getBatchs() {
		
		return batchDao.getBatchs();
				
	}
	
	@Override
	@Transactional
	public List<Batch> getBatchs(int id) {
		
		return batchDao.getBatchs(id);
				
	}

	@Override
	@Transactional
	public Batch addBatch(Batch batch) {
	
		return batchDao.addBatch(batch);
		
	}

	@Override
	@Transactional
	public Batch deleteBatch(int id) {
		
		return batchDao.deleteBatch(id);
		
	}
	
	

}
