package com.keonics.services;

import java.util.List;

import com.keonics.entity.Center;

public interface CenterService {
	
	public List<Center> getCenters();
	
	public List<Center> getCenters(int id);
	
	public Center addCenter(Center center);
	
	public Center delete(int id);
}
