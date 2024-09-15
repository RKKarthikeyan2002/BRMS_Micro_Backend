package com.karthi.brms.repoimpli;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.Payment;
import com.karthi.brms.repo.PaymentRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PaymentRepoImpli implements PaymentRepo {
	EntityManager eManager;

	public PaymentRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Payment save(Payment payment) {
		eManager.persist(payment);
		return payment;
	}
	
}
