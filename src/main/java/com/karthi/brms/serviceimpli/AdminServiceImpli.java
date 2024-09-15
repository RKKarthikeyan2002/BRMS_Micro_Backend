package com.karthi.brms.serviceimpli;

import org.springframework.stereotype.Service;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Admin;
import com.karthi.brms.repo.AdminRepo;
import com.karthi.brms.service.AdminService;

@Service
public class AdminServiceImpli implements AdminService {
	AdminRepo aRepo;

	public AdminServiceImpli(AdminRepo aRepo) {
		super();
		this.aRepo = aRepo;
	}

	public Admin login(LoginDto login) {
		Admin admin = aRepo.findByEmail(login.getEmail());
		if (admin != null && admin.getPassword().equals(login.getPassword())) {
			return admin;
		} else {
			return null;
		}
	}

	@Override
	public Admin editAdmin(Admin a) {
		Admin admin = aRepo.findById(a.getId());
		admin.setAge(a.getAge());
		admin.setDob(a.getDob());
		admin.setAddress(a.getAddress());
		admin.setPhone(a.getPhone());
		return aRepo.update(admin);
	}

	@Override
	public Admin editPassword(Long id, String newPassword, String oldPassword) {
		Admin admin = aRepo.findById(id);
		if(newPassword.equals(admin.getPassword())) {
			admin.setPassword(newPassword);
			return aRepo.update(admin);
		}
		return null;
	}

	@Override
	public Admin getAdminById(Long id) {
		return aRepo.findById(id);
	}

}
