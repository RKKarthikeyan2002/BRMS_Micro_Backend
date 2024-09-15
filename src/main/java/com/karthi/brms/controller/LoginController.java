package com.karthi.brms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.serviceimpli.AdminServiceImpli;
import com.karthi.brms.serviceimpli.CustomerServiceImpli;
import com.karthi.brms.serviceimpli.StaffServiceImpli;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	CustomerServiceImpli customerServiceImpli;
	AdminServiceImpli adminServiceImpli;
	StaffServiceImpli staffServiceImpli;

	public LoginController(CustomerServiceImpli customerServiceImpli, AdminServiceImpli adminServiceImpli,
			StaffServiceImpli staffServiceImpli) {
		super();
		this.customerServiceImpli = customerServiceImpli;
		this.adminServiceImpli = adminServiceImpli;
		this.staffServiceImpli = staffServiceImpli;
	}

	@PostMapping
	public Object login(@RequestBody LoginDto login) {
		if (customerServiceImpli.login(login) != null) {
			return customerServiceImpli.login(login);
		}
		if (adminServiceImpli.login(login) != null) {
			return adminServiceImpli.login(login);
		}
		if (staffServiceImpli.login(login) != null) {
			return staffServiceImpli.login(login);
		}
		return null;
	}
}
