package com.karthi.brms.service;

import java.util.List;

import com.karthi.brms.model.Booking;

public interface BookingService {

	Booking createBooking(Booking booking);

	List<Booking> getAllBooking();

	Booking editStatus(Long bookingId, String status);

	Booking editAdvanceStatus(Long bookingId, String status);

	Booking editTotalStatus(Long bookingId, String status);

	Booking getBookingById(Long bookingId);

	List<Booking> getAvailableBookings(Long bikeId, String status);

	Booking editTotalAmount(Long bookingId, double totalAmount);

	double calculateBikeAmount(Long bikeId);

}
