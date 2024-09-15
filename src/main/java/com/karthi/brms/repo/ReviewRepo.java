package com.karthi.brms.repo;

import java.util.List;

import com.karthi.brms.model.Review;

public interface ReviewRepo {

	Review save(Review review);

	List<Review> findReviewsByBikeId(Long bikeId);

}
