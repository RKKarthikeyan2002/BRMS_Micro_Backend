package com.karthi.brms.serviceimpli;

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
	
}
