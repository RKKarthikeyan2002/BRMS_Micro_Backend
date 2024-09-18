package com.karthi.brms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.Booking;
import com.karthi.brms.repo.BookingRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BookingRepoImpli implements BookingRepo {
	EntityManager eManager;

	public BookingRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Booking save(Booking booking) {
		eManager.persist(booking);
		return booking;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findAll() {
		String hql = "From Booking ORDER BY id DESC";
		return eManager.createQuery(hql).getResultList();
	}

	@Override
	public Booking update(Booking booking) {
		return eManager.merge(booking);
	}

	@Override
	public Booking findById(Long bookingId) {
		return eManager.find(Booking.class, bookingId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findByBikeIdAndStatusNot(Long bikeId, String status) {
		String hql = "SELECT b FROM Booking b WHERE b.bike.id = :bikeId AND b.status <> :status AND b.status <> :rejectstatus";
		return eManager.createQuery(hql).setParameter("bikeId", bikeId).setParameter("status", status).setParameter("rejectstatus", "Rejected").getResultList();
	}

	@Override
	public double calculateTotalBikeAmount(Long bikeId) {
		String hql = "SELECT SUM(b.totalAmount) FROM Booking b WHERE b.bike.id = :bikeId";
		Double totalAmount = (Double) eManager.createQuery(hql).setParameter("bikeId", bikeId).getSingleResult();

	    return totalAmount != null ? totalAmount : 0.0;
	}
	
}
