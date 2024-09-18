package com.karthi.brms.service;

import java.util.List;

import com.karthi.brms.model.Payment;

public interface PaymentService {

	Payment savePayment(Payment payment);

	List<Payment> getPaymentByBookingId(Long bookingId);

	List<Payment> getPaymentByBikeId(Long bikeId);

}
