package com.karthi.brms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.brms.model.Booking;
import com.karthi.brms.model.Customer;
import com.karthi.brms.repo.BookingRepo;
import com.karthi.brms.repo.CustomerRepo;
import com.karthi.brms.service.BookingService;

@Service
public class BookingServiceImpli implements BookingService {
	BookingRepo bRepo;
	CustomerRepo cRepo;

	public BookingServiceImpli(BookingRepo bRepo, CustomerRepo cRepo) {
		super();
		this.bRepo = bRepo;
		this.cRepo = cRepo;
	}

	@Override
	public Booking createBooking(Booking booking) {
		return bRepo.save(booking);
	}

	@Override
	public List<Booking> getAllBooking() {
		return bRepo.findAll();
	}

	@Override
	public Booking editStatus(Long bookingId, String status) {
		Booking booking = bRepo.findById(bookingId);
		if(status.equals("Rejected") || status.equals("Closed")) {
			Customer customer = cRepo.findById(booking.getCustomer().getId());
			customer.setStatus("No");
			cRepo.updateStatus(customer);
		}
		
		booking.setStatus(status);
		return bRepo.update(booking);
	}

	@Override
	public Booking editAdvanceStatus(Long bookingId, String status) {
		Booking booking = bRepo.findById(bookingId);
		booking.setAdvanceStatus(status);
		return bRepo.update(booking);
	}

	@Override
	public Booking editTotalStatus(Long bookingId, String status) {
		Booking booking = bRepo.findById(bookingId);
		booking.setAmountStatus(status);
		return bRepo.update(booking);
	}

	@Override
	public Booking getBookingById(Long bookingId) {
		return bRepo.findById(bookingId);
	}

	@Override
	public List<Booking> getAvailableBookings(Long bikeId, String status) {
        return bRepo.findByBikeIdAndStatusNot(bikeId, status);
	}

	@Override
	public Booking editTotalAmount(Long bookingId, double totalAmount) {
		Booking booking = bRepo.findById(bookingId);
		booking.setTotalAmount(totalAmount);
		return bRepo.update(booking);
	}

	@Override
	public double calculateBikeAmount(Long bikeId) {
		return bRepo.calculateTotalBikeAmount(bikeId);
	}
}
