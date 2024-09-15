package com.karthi.brms.repoimpli;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.Damage;
import com.karthi.brms.repo.DamageRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DamageRepoImpli implements DamageRepo {
	EntityManager eManager;

	public DamageRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Damage save(Damage damage) {
		eManager.persist(damage);
		return damage;
	}

}
