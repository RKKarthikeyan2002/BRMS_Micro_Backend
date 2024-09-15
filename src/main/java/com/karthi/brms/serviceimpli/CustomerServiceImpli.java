package com.karthi.brms.serviceimpli;

import org.springframework.stereotype.Service;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Customer;
import com.karthi.brms.repo.CustomerRepo;
import com.karthi.brms.service.CustomerService;

@Service
public class CustomerServiceImpli implements CustomerService {
	CustomerRepo cRepo;
	
	public CustomerServiceImpli(CustomerRepo cRepo) {
		super();
		this.cRepo = cRepo;
	}

	public Customer addCustomer(Customer customer) {
		customer.setRole("customer");
		return cRepo.save(customer);
	}

	public Customer login(LoginDto login) {
		Customer customer = cRepo.findByEmail(login.getEmail());
		if (customer != null && customer.getPassword().equals(login.getPassword())) {
			return customer;
		} else {
			return null;
		}
	}

	public Customer getCustomerById(Long id) {
		return cRepo.findById(id);
	}

	@Override
	public void updateStatus(Long customerId, String status) {
		Customer customer = cRepo.findById(customerId);
		customer.setStatus(status);
		cRepo.updateStatus(customer);
	}

	public Customer editCustomer(Customer c) {
		Customer customer = cRepo.findById(c.getId());
		customer.setAge(c.getAge());
		customer.setDob(c.getDob());
		customer.setAddress(c.getAddress());
		customer.setPhone(c.getPhone());
		return cRepo.update(customer);
	}

	public Customer editPassword(Long id, String newPassword, String oldPassword) {
		Customer customer = cRepo.findById(id);
		if(newPassword.equals(customer.getPassword())) {
			customer.setPassword(newPassword);
			return cRepo.update(customer);
		}
		return null;
	}

}
