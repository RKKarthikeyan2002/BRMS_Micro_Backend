package com.karthi.brms.service;

import java.util.List;

import com.karthi.brms.model.Bike;

public interface BikeService {
	public List<Bike> getAllBike();
	
	public List<Bike> getBikeByCustomer(Long customerId);
	
	public Bike addBike(Bike bike);
	
	public Bike editStatus(long bikeId, String status);
	
	public Bike getBikeById(Long bikeId);
	
	public Bike updateBike(Bike bike);
}
