package com.karthi.brms.service;

import java.util.List;

import com.karthi.brms.model.Review;

public interface ReviewService {

	Review saveReview(Review review);

	List<Review> getReviewsByBikeId(Long bikeId);

}
