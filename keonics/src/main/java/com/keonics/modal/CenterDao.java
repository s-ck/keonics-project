package com.keonics.modal;

import java.util.List;

import com.keonics.entity.Center;

public interface CenterDao {

	public List<Center> getCenters();
	
	public List<Center> getCenters(int id);
	
	public Center addCenter(Center center);
	
	public Center delete(int id);
	
}
