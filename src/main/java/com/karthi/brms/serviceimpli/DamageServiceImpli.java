package com.karthi.brms.serviceimpli;

import org.springframework.stereotype.Service;

import com.karthi.brms.model.Damage;
import com.karthi.brms.repo.DamageRepo;
import com.karthi.brms.service.DamageService;

@Service
public class DamageServiceImpli implements DamageService {
	DamageRepo dRepo;

	public DamageServiceImpli(DamageRepo dRepo) {
		super();
		this.dRepo = dRepo;
	}

	@Override
	public Damage addDamage(Damage damage) {
		return dRepo.save(damage);
	}

}
