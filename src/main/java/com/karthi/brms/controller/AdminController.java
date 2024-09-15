package com.karthi.brms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.brms.model.Admin;
import com.karthi.brms.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	@GetMapping("/{id}")
	public Admin getAdminTypeById(@PathVariable Long id) {
		return adminService.getAdminById(id);
	}

	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminService.editAdmin(admin);
	}

	@PutMapping("/update/{id}/password")
	public Admin updatePassword(@RequestParam("newPassword") String newPassword,
			@RequestParam("oldPassword") String oldPassword, @PathVariable Long id) {
		return adminService.editPassword(id, newPassword, oldPassword);
	}
}
