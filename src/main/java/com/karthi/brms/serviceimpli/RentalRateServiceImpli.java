package com.karthi.brms.serviceimpli;

import org.springframework.stereotype.Service;

import com.karthi.brms.model.RentalRate;
import com.karthi.brms.repo.RentalRateRepo;
import com.karthi.brms.service.RentalRateService;

@Service
public class RentalRateServiceImpli implements RentalRateService {
	RentalRateRepo rRepo;

	public RentalRateServiceImpli(RentalRateRepo rRepo) {
		super();
		this.rRepo = rRepo;
	}

	@Override
	public RentalRate addRentalRate(RentalRate rr) {
		return rRepo.save(rr);
	}

}
