package com.karthi.brms.repoimpli;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findPaymentByBookingId(Long bookingId) {
		String hql = "SELECT p FROM Payment p WHERE p.booking.id = :bookingId";
		return eManager.createQuery(hql).setParameter("bookingId", bookingId).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> findPaymentByBikeId(Long bikeId) {
		String hql = "SELECT p FROM Payment p WHERE p.booking.bike.id = :bikeId";
		return eManager.createQuery(hql).setParameter("bikeId", bikeId).getResultList();
	}
	
}
