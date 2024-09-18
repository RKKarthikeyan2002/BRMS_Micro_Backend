package com.karthi.brms.repo;

import java.util.List;

import com.karthi.brms.model.ContactUs;

public interface ContactRepo {

	void save(ContactUs contactUs);

	List<ContactUs> getAllFeedback();

}
