package com.karthi.brms.repo;

import java.util.List;

import com.karthi.brms.model.Bike;
import com.karthi.brms.model.Customer;

public interface BikeRepo {

	List<Bike> findAll();

	List<Bike> findBikesByCustomer(Customer customer);

	Bike save(Bike bike);

	Bike findById(long bikeId);

	Bike update(Bike bike);

}
