package com.karthi.brms.repo;

import java.util.List;

import com.karthi.brms.model.Staff;

public interface StaffRepo {
	public Staff findByEmail(String email);

	public Staff save(Staff staff);

	public List<Staff> findAll();

	public Staff findById(Long id);

	public Staff update(Staff staff);
}
