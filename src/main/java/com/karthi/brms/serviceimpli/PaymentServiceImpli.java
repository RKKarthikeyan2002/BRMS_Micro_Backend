package com.karthi.brms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.brms.model.Payment;
import com.karthi.brms.repo.PaymentRepo;
import com.karthi.brms.service.PaymentService;

@Service
public class PaymentServiceImpli implements PaymentService {
	PaymentRepo pRepo;

	public PaymentServiceImpli(PaymentRepo pRepo) {
		super();
		this.pRepo = pRepo;
	}

	@Override
	public Payment savePayment(Payment payment) {
		return pRepo.save(payment);
	}

	@Override
	public List<Payment> getPaymentByBookingId(Long bookingId) {
		return pRepo.findPaymentByBookingId(bookingId);
	}

	@Override
	public List<Payment> getPaymentByBikeId(Long bikeId) {
		return pRepo.findPaymentByBikeId(bikeId);
	}
	
}
