package com.karthi.brms.repoimpli;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.RentalRate;
import com.karthi.brms.repo.RentalRateRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RentalRateRepoImpli implements RentalRateRepo {
	EntityManager eManager;

	public RentalRateRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public RentalRate save(RentalRate rr) {
		eManager.persist(rr);
		return rr;
	}
}
