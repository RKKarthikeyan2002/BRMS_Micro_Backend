package com.karthi.brms.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.brms.model.Bike;
import com.karthi.brms.model.Customer;
import com.karthi.brms.model.Review;
import com.karthi.brms.service.BikeService;
import com.karthi.brms.service.CustomerService;
import com.karthi.brms.service.ReviewService;

@RestController
@RequestMapping("/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
	ReviewService reviewService;
	BikeService bikeService;
	CustomerService customerService;

	public ReviewController(ReviewService reviewService, BikeService bikeService, CustomerService customerService) {
		super();
		this.reviewService = reviewService;
		this.bikeService = bikeService;
		this.customerService = customerService;
	}

	@PostMapping
	public Review submitReview(@RequestParam("rating") int rating, @RequestParam("comment") String comment,
			@RequestParam("bike.id") Long bikeId, @RequestParam("customer.id") Long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		Bike bike = bikeService.getBikeById(bikeId);
				
		Review review = new Review();
		review.setRating(rating);
		review.setComment(comment);
		review.setDate(Date.valueOf(LocalDate.now()));
		
		review.setBike(bike);
		review.setCustomer(customer);

		return reviewService.saveReview(review);
	}
	
	@GetMapping("/{bikeId}")
    public List<Review> getReviews(@PathVariable Long bikeId) {
        return reviewService.getReviewsByBikeId(bikeId);
    }
}
