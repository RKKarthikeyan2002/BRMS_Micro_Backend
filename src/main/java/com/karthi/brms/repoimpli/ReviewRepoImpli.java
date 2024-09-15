package com.karthi.brms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.Review;
import com.karthi.brms.repo.ReviewRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ReviewRepoImpli implements ReviewRepo {
	EntityManager eManager;

	public ReviewRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@Override
	public Review save(Review review) {
		eManager.persist(review);
		return review;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> findReviewsByBikeId(Long bikeId) {
		String hql = "SELECT r FROM Review r WHERE r.bike.id = :bikeId ORDER BY r.id DESC";
		return eManager.createQuery(hql).setParameter("bikeId", bikeId).getResultList();
	}
	
}
