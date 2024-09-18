package com.karthi.brms.service;

import java.util.List;

import com.karthi.brms.model.ContactUs;

public interface ContactService {

	ContactUs requestToAdmin(ContactUs contactUs);

	List<ContactUs> getAllFeedbacks();

}
