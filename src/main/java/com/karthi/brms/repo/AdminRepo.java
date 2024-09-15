package com.karthi.brms.repo;

import com.karthi.brms.model.Admin;

public interface AdminRepo {

	Admin findByEmail(String email);

	Admin findById(Long id);

	Admin update(Admin admin);

}
