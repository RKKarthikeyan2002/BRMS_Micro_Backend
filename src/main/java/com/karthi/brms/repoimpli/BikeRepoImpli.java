package com.karthi.brms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.Bike;
import com.karthi.brms.model.Customer;
import com.karthi.brms.repo.BikeRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BikeRepoImpli implements BikeRepo {
	EntityManager eManager;

	public BikeRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bike> findAll() {
		String hql = "From Bike ORDER BY id DESC";
		return eManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bike> findBikesByCustomer(Customer customer) {
		String hql = "select b from Bike b where b.customer = :customer";
		return eManager.createQuery(hql).setParameter("customer", customer).getResultList();
	}

	@Override
	public Bike save(Bike bike) {
		eManager.merge(bike);
		return bike;
	}

	@Override
	public Bike findById(long bikeId) {
		return eManager.find(Bike.class, bikeId);
	}

	@Override
	public Bike update(Bike bike) {
		return eManager.merge(bike);
	}

}
