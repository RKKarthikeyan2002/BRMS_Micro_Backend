package com.karthi.brms.repo;

import java.util.List;

import com.karthi.brms.model.Booking;

public interface BookingRepo {

	Booking save(Booking booking);

	List<Booking> findAll();

	Booking findById(Long bookingId);

	Booking update(Booking booking);

	List<Booking> findByBikeIdAndStatusNot(Long bikeId, String status);

}
