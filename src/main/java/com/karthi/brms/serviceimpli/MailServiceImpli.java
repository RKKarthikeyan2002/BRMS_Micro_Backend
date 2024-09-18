package com.karthi.brms.serviceimpli;

import java.text.DecimalFormat;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.karthi.brms.model.Bike;
import com.karthi.brms.service.BikeService;
import com.karthi.brms.service.BookingService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpli {
	JavaMailSender javaMailSender;
	BookingService bookingService;
	BikeService bikeService;

	public MailServiceImpli(JavaMailSender javaMailSender, BookingService bookingService, BikeService bikeService) {
		super();
		this.javaMailSender = javaMailSender;
		this.bookingService = bookingService;
		this.bikeService = bikeService;
	}

	public void sendBikeStatusMail(String customerMail, String name, String status, String bikeNo) throws MessagingException {
		String subject = "";
		String text = "";

		if ("Accepted".equalsIgnoreCase(status)) {
			subject = "Bike Acceptance Notification";
			text = "Dear " + name + ",\n\nYour bike with number " + bikeNo
					+ " has been accepted.  Please hand over your bike to R K Bikes on the specified date.\n\nThank you.";
		} else if ("Rejected".equalsIgnoreCase(status)) {
			subject = "Bike Rejection Notification";
			text = "Dear " + name + ",\n\nUnfortunately, your bike with number " + bikeNo
					+ " has been rejected.\n\nPlease contact support for more details.";
		}

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(customerMail);
		helper.setSubject(subject);
		helper.setText(text, true);

		javaMailSender.send(message);
	}

	public void customerCommission(Long bikeId) throws MessagingException {
		double totalAmount = bookingService.calculateBikeAmount(bikeId);
        double amount = totalAmount / 3;
        Bike bike = bikeService.getBikeById(bikeId);
        
        if(bike.getCustomer().getName().equals("")) {
        	
        }
        else {
        	DecimalFormat df = new DecimalFormat("#.##");
            String formattedAmount = df.format(amount);

            String customerEmail = bike.getCustomer().getEmail();
            String customerName = bike.getCustomer().getName();

            String subject = "Bike Earnings Notification";
            String text = "Dear " + customerName + ",\n\n" +
                          "Congratulations! Your bike with number " + bike.getNumber() +
                          " has earned a total amount of Rupees " + formattedAmount + ".\n" +
                          "This amount will be sent to your mobile number "+ bike.getCustomer().getPhone() +".\n\n" +
                          "Thank you for your business.";

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(customerEmail);
            helper.setSubject(subject);
            helper.setText(text, true);

            javaMailSender.send(message);
		}
        
	}

	public void sendBookingStatusMail(String customerMail, String name, String status, String bikeNo) throws MessagingException {
		String subject = "";
		String text = "";

		if ("Confirmed".equalsIgnoreCase(status)) {
			subject = "Booking Acceptance Notification";
			text = "Dear " + name + ",\n\nYour Booking with bike number " + bikeNo
					+ " has been accepted. \n\nPlease pay your booking advance amount through booking. \n\nThank you.";
		} else if ("Rejected".equalsIgnoreCase(status)) {
			subject = "Booking Rejection Notification";
			text = "Dear " + name + ",\n\nUnfortunately, your Booking with number " + bikeNo
					+ " has been rejected.\n\nPlease contact support for more details.";
		}

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(customerMail);
		helper.setSubject(subject);
		helper.setText(text, true);

		javaMailSender.send(message);
	}
}
