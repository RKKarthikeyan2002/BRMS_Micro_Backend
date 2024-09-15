package com.karthi.brms.repoimpli;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.Customer;
import com.karthi.brms.repo.CustomerRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepoImpli implements CustomerRepo {
	private EntityManager eManager;

	public CustomerRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Customer save(Customer customer) {
		eManager.persist(customer);
		return customer;
	}

	@Override
	public Customer findByEmail(String email) {
		String hql = "select c from Customer c where c.email = :email";
		try {
			return (Customer) eManager.createQuery(hql).setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Customer findById(Long id) {
		String hql = "select c from Customer c where c.id = :id";
		try {
			return (Customer) eManager.createQuery(hql).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void updateStatus(Customer customer) {
		eManager.merge(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return eManager.merge(customer);
	}

}
