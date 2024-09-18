package com.karthi.brms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.ContactUs;
import com.karthi.brms.repo.ContactRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ContactRepoImpli implements ContactRepo {
	EntityManager eManager;

	public ContactRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}
	
	@Override
	public void save(ContactUs contactUs) {
		eManager.persist(contactUs);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactUs> getAllFeedback() {
		String hql = "from ContactUs";
		return eManager.createQuery(hql).getResultList();
	}
	
}
