package com.karthi.brms.service;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	
	public Customer login(LoginDto login);
	
	public Customer getCustomerById(Long id);

	public void updateStatus(Long customerId, String status);
	
	public Customer editPassword(Long id, String newPassword, String oldPassword);
	
	public Customer editCustomer(Customer c);
}
