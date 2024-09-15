package com.karthi.brms.repo;

import java.util.List;

import com.karthi.brms.model.BikeType;

public interface BikeTypeRepo {

	List<String> findAllName();

	BikeType findByName(String name);

	BikeType save(BikeType bikeType);

	void deleteById(Long id);

}
