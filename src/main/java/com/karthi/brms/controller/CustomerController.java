package com.karthi.brms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.brms.model.Customer;
import com.karthi.brms.serviceimpli.CustomerServiceImpli;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	private CustomerServiceImpli customerServiceImpli;

	public CustomerController(CustomerServiceImpli customerServiceImpli) {
		super();
		this.customerServiceImpli = customerServiceImpli;
	}

	@PostMapping("/register")
	public Customer createCustomer(@RequestBody Customer customer) {
		customer.setStatus("No");
		customer.setRole("customer");
		return customerServiceImpli.addCustomer(customer);
	}
	
	@GetMapping("/{id}")
	public Customer getBikeTypeById(@PathVariable Long id) {
		return customerServiceImpli.getCustomerById(id);
	}
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerServiceImpli.editCustomer(customer);
	}
	
	@PutMapping("/update/{id}/password")
	public Customer updatePassword(@RequestParam("newPassword") String newPassword, @RequestParam("oldPassword") String oldPassword, @PathVariable Long id) {
		return customerServiceImpli.editPassword(id, newPassword, oldPassword);
	}
}
