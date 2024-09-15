package com.karthi.brms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Staff;
import com.karthi.brms.repo.StaffRepo;
import com.karthi.brms.service.StaffService;

@Service
public class StaffServiceImpli implements StaffService {
	StaffRepo sRepo;

	public StaffServiceImpli(StaffRepo sRepo) {
		super();
		this.sRepo = sRepo;
	}

	@Override
	public Staff login(LoginDto login) {
		Staff staff = sRepo.findByEmail(login.getEmail());
		if (staff != null && staff.getPassword().equals(login.getPassword())) {
			return staff;
		} else {
			return null;
		}
	}

	public Staff addStaff(Staff staff) {
		staff.setRole("Staff");
		return sRepo.save(staff);
	}

	public List<Staff> getAllStaff() {
		return sRepo.findAll();
	}

	public Staff editStaff(Staff s) {
		Staff staff = sRepo.findById(s.getId());
		staff.setAge(s.getAge());
		staff.setDob(s.getDob());
		staff.setAddress(s.getAddress());
		staff.setPhone(s.getPhone());
		return sRepo.update(staff);
	}

	public Staff editPassword(Long id, String newPassword, String oldPassword) {
		Staff staff = sRepo.findById(id);
		if(newPassword.equals(staff.getPassword())) {
			staff.setPassword(newPassword);
			return sRepo.update(staff);
		}
		return null;
	}

	public Staff getStaffById(Long id) {
		return sRepo.findById(id);
	}
	
}
