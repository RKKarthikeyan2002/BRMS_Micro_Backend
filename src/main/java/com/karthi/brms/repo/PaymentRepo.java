package com.karthi.brms.repo;

import java.util.List;

import com.karthi.brms.model.Payment;

public interface PaymentRepo {

	Payment save(Payment payment);

	List<Payment> findPaymentByBookingId(Long bookingId);

	List<Payment> findPaymentByBikeId(Long bikeId);

}
