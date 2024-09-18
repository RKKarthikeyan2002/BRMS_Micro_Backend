package com.karthi.brms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.brms.serviceimpli.MailServiceImpli;

import jakarta.mail.MessagingException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mail")
public class MailController {
	MailServiceImpli mailServiceImpli;

	public MailController(MailServiceImpli mailServiceImpli) {
		super();
		this.mailServiceImpli = mailServiceImpli;
	}
	
	@PostMapping("/bikeStatus")
    public void sendBikeStatusEmail(
            @RequestParam("status") String status,
            @RequestParam("customerName") String name,
            @RequestParam("customerMail") String customerMail,
            @RequestParam("bikeNo") String bikeNo) throws MessagingException {

        mailServiceImpli.sendBikeStatusMail(customerMail, name, status, bikeNo);
    }
	
	@PostMapping("/bikeCommission")
    public void sendCommissiontoCustomer(@RequestParam("bikeId") Long bikeId) throws MessagingException {
		mailServiceImpli.customerCommission(bikeId);
    }

	@PostMapping("/bookingStatus")
    public void sendBookingStatusEmail(
            @RequestParam("status") String status,
            @RequestParam("customerName") String name,
            @RequestParam("customerMail") String customerMail,
            @RequestParam("bikeNo") String bikeNo) throws MessagingException {

        mailServiceImpli.sendBookingStatusMail(customerMail, name, status, bikeNo);
    }
}
