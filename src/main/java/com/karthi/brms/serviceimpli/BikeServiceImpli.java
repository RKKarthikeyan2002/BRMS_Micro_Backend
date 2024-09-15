package com.karthi.brms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.brms.model.Bike;
import com.karthi.brms.model.Customer;
import com.karthi.brms.repo.BikeRepo;
import com.karthi.brms.repo.CustomerRepo;
import com.karthi.brms.service.BikeService;

@Service
public class BikeServiceImpli implements BikeService {
	BikeRepo bRepo;
	CustomerRepo cRepo;

	public BikeServiceImpli(BikeRepo bRepo, CustomerRepo cRepo) {
		super();
		this.bRepo = bRepo;
		this.cRepo = cRepo;
	}

	public List<Bike> getAllBike() {
		return bRepo.findAll();
	}

	public List<Bike> getBikeByCustomer(Long customerId) {
		Customer customer = cRepo.findById(customerId);
		return bRepo.findBikesByCustomer(customer);
	}

	public Bike addBike(Bike bike) {
		return bRepo.save(bike);
	}

	public Bike editStatus(long bikeId, String status) {
		Bike bike = bRepo.findById(bikeId);
		bike.setStatus(status);
		return bRepo.update(bike);
	}

	public Bike getBikeById(Long bikeId) {
		return bRepo.findById(bikeId);
	}

	public Bike updateBike(Bike bike) {
		return bRepo.update(bike);
	}

}
