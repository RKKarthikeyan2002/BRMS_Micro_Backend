package com.karthi.brms.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.karthi.brms.model.Booking;
import com.karthi.brms.service.BikeService;
import com.karthi.brms.service.BookingService;
import com.karthi.brms.service.CustomerService;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
	BookingService bookingService;
	CustomerService customerService;
	BikeService bikeService;

	public BookingController(BookingService bookingService, CustomerService customerService, BikeService bikeService) {
		super();
		this.bookingService = bookingService;
		this.customerService = customerService;
		this.bikeService = bikeService;
	}

	@PostMapping("/addBooking")
	public Booking createBooking(@RequestParam("name") String name, @RequestParam("age") int age,
	        @RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate,
	        @RequestParam("totalAmount") double totalAmount, @RequestParam("bikeId") Long bikeId,
	        @RequestParam("status") String status, @RequestParam("customerId") Long customerId,
	        @RequestParam("license") MultipartFile license, @RequestParam("phone") String phone)
	        throws IOException {

	    Booking booking = new Booking();
	    booking.setName(name);
	    booking.setAge(age);
	    booking.setFromDate(startDate);
	    booking.setToDate(endDate);
	    booking.setTotalAmount(totalAmount);
	    booking.setAdvance(totalAmount / 2);
	    booking.setLicense(license.getBytes());
	    booking.setPhone(phone);
	    booking.setBike(bikeService.getBikeById(bikeId));
	    booking.setStatus(status);

	    if (customerService.getCustomerById(customerId) != null) {
	        booking.setCustomer(customerService.getCustomerById(customerId));
	        customerService.updateStatus(customerId, "yes");
	    }

	    return bookingService.createBooking(booking);
	}


	@GetMapping("/all")
	public List<Booking> getAllBikes() {
		return bookingService.getAllBooking();
	}
	
	@PatchMapping("/{bookingId}")
	public Booking updateBookingStatus(@PathVariable Long bookingId, @RequestParam("status") String status) {
		return bookingService.editStatus(bookingId, status);
	}
	
	@PatchMapping("/advanceStatus/{bookingId}")
	public Booking updateBookingAdvanceStatus(@PathVariable Long bookingId, @RequestParam("status") String status) {
		return bookingService.editAdvanceStatus(bookingId, status);
	}
	
	@PatchMapping("/totalStatus/{bookingId}")
	public Booking updateBookingTotalStatus(@PathVariable Long bookingId, @RequestParam("status") String status) {
		return bookingService.editTotalStatus(bookingId, status);
	}
	
	@PatchMapping("/addDamageAmount/{bookingId}")
	public Booking updateTotalAmountWithDamageAmount(@PathVariable Long bookingId, @RequestParam("totalAmount") double totalAmount) {
		return bookingService.editTotalAmount(bookingId, totalAmount);
	}
	
	@GetMapping("/available/{bikeId}")
    public List<Booking> getAvailableBookings(@PathVariable Long bikeId) {
        return bookingService.getAvailableBookings(bikeId, "Closed");
    }
}
