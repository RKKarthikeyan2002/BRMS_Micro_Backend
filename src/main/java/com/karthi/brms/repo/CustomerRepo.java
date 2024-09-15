package com.karthi.brms.repo;

import com.karthi.brms.model.Customer;

public interface CustomerRepo {

	Customer save(Customer customer);

	Customer findByEmail(String email);

	Customer findById(Long customerId);

	void updateStatus(Customer customer);

	Customer update(Customer customer);

}
