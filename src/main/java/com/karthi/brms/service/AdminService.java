package com.karthi.brms.service;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Admin;

public interface AdminService {
	public Admin login(LoginDto login);

	public Admin editAdmin(Admin admin);

	public Admin editPassword(Long id, String newPassword, String oldPassword);

	public Admin getAdminById(Long id);
}
