package com.karthi.brms.service;

import java.util.List;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Staff;

public interface StaffService {
	public Staff login(LoginDto login);
	
	public Staff addStaff(Staff staff);
	
	public List<Staff> getAllStaff();
	
	public Staff editStaff(Staff staff);
	
	public Staff editPassword(Long id, String newPassword, String oldPassword);
	
	public Staff getStaffById(Long id);
}
