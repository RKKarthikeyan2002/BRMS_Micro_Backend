package com.karthi.brms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.brms.model.Staff;
import com.karthi.brms.serviceimpli.StaffServiceImpli;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "http://localhost:3000")
public class StaffController {
	StaffServiceImpli staffServiceImpli;

	public StaffController(StaffServiceImpli staffServiceImpli) {
		super();
		this.staffServiceImpli = staffServiceImpli;
	}
	
	@PostMapping("/addStaff")
	public Staff createStaff(@RequestBody Staff staff) {
		return staffServiceImpli.addStaff(staff);
	}
	
	@GetMapping("/all")
	public List<Staff> getBikeTypeById() {
		return staffServiceImpli.getAllStaff();
	}
	
	@GetMapping("{id}")
	public Staff getStaffById(@PathVariable Long id) {
		return staffServiceImpli.getStaffById(id);
	}
	
	@PutMapping("/update")
	public Staff updateStaff(@RequestBody Staff staff) {
		return staffServiceImpli.editStaff(staff);
	}
	
	@PutMapping("/update/{id}/password")
	public Staff updatePassword(@RequestParam("newPassword") String newPassword, @RequestParam("oldPassword") String oldPassword, @PathVariable Long id) {
		return staffServiceImpli.editPassword(id, newPassword, oldPassword);
	}
}
