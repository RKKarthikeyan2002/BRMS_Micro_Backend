package com.karthi.brms.serviceimpli;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karthi.brms.model.ContactUs;
import com.karthi.brms.repo.ContactRepo;
import com.karthi.brms.service.ContactService;

@Service
public class ContactServiceImpli implements ContactService {
	ContactRepo cRepo;

	public ContactServiceImpli(ContactRepo cRepo) {
		super();
		this.cRepo = cRepo;
	}

	@Override
	public ContactUs requestToAdmin(ContactUs contactUs) {
		cRepo.save(contactUs);
		return contactUs;
	}

	@Override
	public List<ContactUs> getAllFeedbacks() {
		return cRepo.getAllFeedback();
	}
	
}
