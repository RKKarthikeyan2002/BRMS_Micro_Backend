package com.karthi.brms.controller;

import com.karthi.brms.model.Booking;
import com.karthi.brms.model.Payment;
import com.karthi.brms.service.BookingService;
import com.karthi.brms.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

	private PaymentService paymentService;
	private BookingService bookingService;

	public PaymentController(PaymentService paymentService, BookingService bookingService) {
		super();
		this.paymentService = paymentService;
		this.bookingService = bookingService;
	}

	@PostMapping("/save")
	public Payment savePayment(@RequestParam("paymentId") String paymentId, @RequestParam("name") String name,
			@RequestParam("amount") double amount, @RequestParam("bookingId") Long bookingId) {
		Booking booking = bookingService.getBookingById(bookingId);
		
		Payment payment = new Payment();
		payment.setPaymentId(paymentId);
		payment.setName(name);
		payment.setAmount(amount);
		payment.setBooking(booking);
		
		return paymentService.savePayment(payment);
	}
}
