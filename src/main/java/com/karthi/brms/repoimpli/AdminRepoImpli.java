package com.karthi.brms.repoimpli;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.Admin;
import com.karthi.brms.repo.AdminRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminRepoImpli implements AdminRepo {
	EntityManager eManager;

	public AdminRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Admin findByEmail(String email) {
		String hql = "select c from Admin c where email = :email";
		try {
			return (Admin) eManager.createQuery(hql).setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Admin findById(Long id) {
		return eManager.find(Admin.class, id);
	}

	@Override
	public Admin update(Admin admin) {
		return eManager.merge(admin);
	}

}
