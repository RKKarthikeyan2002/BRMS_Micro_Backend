package com.karthi.brms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.brms.model.ContactUs;
import com.karthi.brms.service.ContactService;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:3000/")
public class ContactController {
	ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@PostMapping("/request")
	public ContactUs createFeedback(@RequestBody ContactUs contactUs) {
		return contactService.requestToAdmin(contactUs);
	}

	@GetMapping("/all")
	public List<ContactUs> getAllFeedbacks() {
		return contactService.getAllFeedbacks();
	}
}
