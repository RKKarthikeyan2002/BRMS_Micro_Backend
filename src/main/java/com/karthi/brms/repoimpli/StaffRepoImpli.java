package com.karthi.brms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.Staff;
import com.karthi.brms.repo.StaffRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StaffRepoImpli implements StaffRepo {
	EntityManager eManager;

	public StaffRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Staff findByEmail(String email) {
		String hql = "select c from Staff c where email = :email";
		try {
			return (Staff) eManager.createQuery(hql).setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Staff save(Staff staff) {
		eManager.persist(staff);
		return staff;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> findAll() {
		String hql = "From Staff";
		return eManager.createQuery(hql).getResultList();
	}

	@Override
	public Staff findById(Long id) {
		return eManager.find(Staff.class, id);
	}

	@Override
	public Staff update(Staff staff) {
		return eManager.merge(staff);
	}
}
