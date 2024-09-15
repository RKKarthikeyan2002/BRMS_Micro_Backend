package com.karthi.brms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.brms.model.Review;
import com.karthi.brms.repo.ReviewRepo;
import com.karthi.brms.service.ReviewService;

@Service
public class ReviewServiceImpli implements ReviewService {
	ReviewRepo rRepo;

	public ReviewServiceImpli(ReviewRepo rRepo) {
		super();
		this.rRepo = rRepo;
	}

	@Override
	public Review saveReview(Review review) {
		return rRepo.save(review);
	}

	@Override
	public List<Review> getReviewsByBikeId(Long bikeId) {
		return rRepo.findReviewsByBikeId(bikeId);
	}
	
}
