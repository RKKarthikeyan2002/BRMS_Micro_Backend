package com.karthi.brms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.brms.model.BikeType;
import com.karthi.brms.repo.BikeTypeRepo;
import com.karthi.brms.service.BikeTypeService;

@Service
public class BikeTypeServiceImpli implements BikeTypeService {

	BikeTypeRepo bRepo;

	public BikeTypeServiceImpli(BikeTypeRepo bRepo) {
		super();
		this.bRepo = bRepo;
	}

	@Override
	public List<String> getAllBikeTypes() {
		return bRepo.findAllName();
	}

	@Override
	public BikeType getBikeTypeByName(String name) {
		return bRepo.findByName(name);
	}

	@Override
	public BikeType addBikeType(BikeType bikeType) {
		return bRepo.save(bikeType);
	}

	@Override
	public void deleteBikeType(Long id) {
		bRepo.deleteById(id);
	}

}
