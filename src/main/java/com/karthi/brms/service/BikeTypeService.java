package com.karthi.brms.service;

import java.util.List;
import com.karthi.brms.model.BikeType;

public interface BikeTypeService {
	List<String> getAllBikeTypes();

	BikeType getBikeTypeByName(String name);

	BikeType addBikeType(BikeType bikeType);

	void deleteBikeType(Long id);
}
