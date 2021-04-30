package com.keonics.modal;

import java.util.List;

import com.keonics.entity.Batch;

public interface BatchDao {

	public List<Batch> getBatchs();
	
	public List<Batch> getBatchs(int id);
	
	public Batch addBatch(Batch batch);
	
	public Batch deleteBatch(int id);
	
}
