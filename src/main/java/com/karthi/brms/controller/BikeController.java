package com.karthi.brms.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.karthi.brms.model.Bike;
import com.karthi.brms.model.BikeType;
import com.karthi.brms.model.Customer;
import com.karthi.brms.model.RentalRate;
import com.karthi.brms.service.RentalRateService;
import com.karthi.brms.serviceimpli.BikeServiceImpli;
import com.karthi.brms.serviceimpli.BikeTypeServiceImpli;
import com.karthi.brms.serviceimpli.CustomerServiceImpli;

@RestController
@RequestMapping("/bike")
@CrossOrigin(origins = "http://localhost:3000")
public class BikeController {
	BikeServiceImpli bikeServiceImpli;
	CustomerServiceImpli customerServiceImpli;
	BikeTypeServiceImpli bikeTypeServiceImpli;
	RentalRateService rentalRateService;

	public BikeController(BikeServiceImpli bikeServiceImpli, CustomerServiceImpli customerServiceImpli,
			BikeTypeServiceImpli bikeTypeServiceImpli, RentalRateService rentalRateService) {
		super();
		this.bikeServiceImpli = bikeServiceImpli;
		this.customerServiceImpli = customerServiceImpli;
		this.bikeTypeServiceImpli = bikeTypeServiceImpli;
		this.rentalRateService = rentalRateService;
	}

	@GetMapping("/all")
	public List<Bike> getAllBikes() {
		return bikeServiceImpli.getAllBike();
	}

	@GetMapping("/{customerId}")
	public List<Bike> getBikesByCustomer(@PathVariable Long customerId) {
		return bikeServiceImpli.getBikeByCustomer(customerId);
	}

	@PostMapping("/add")
	public Bike addBike(@RequestParam("number") String number, @RequestParam("brand") String brand,
	        @RequestParam("model") String model, @RequestParam("km") String km, @RequestParam("year") String year,
	        @RequestParam("bikeTypeName") String bikeTypeName, @RequestParam("customerId") Long customerId,
	        @RequestParam("status") String status,
	        @RequestParam("fromDate") Date fromDate,
	        @RequestParam("toDate") Date toDate,
	        @RequestParam(value = "aadhar", required = false) MultipartFile aadhar,
	        @RequestParam(value = "rc", required = false) MultipartFile rc,
	        @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

	    Bike bike = new Bike();
	    Customer customer = customerServiceImpli.getCustomerById(customerId);
	    BikeType bikeType = bikeTypeServiceImpli.getBikeTypeByName(bikeTypeName);

	    bike.setNumber(number);
	    bike.setBrand(brand);
	    bike.setModel(model);
	    bike.setYear(year);
	    bike.setBikeType(bikeType);
	    bike.setCustomer(customer);
	    bike.setKm(km);
	    bike.setFromDate(fromDate);
	    bike.setToDate(toDate);
	    bike.setStatus(status);

	    if (aadhar != null && !aadhar.isEmpty()) {
	        bike.setAadhar(aadhar.getBytes());
	    }

	    if (rc != null && !rc.isEmpty()) {
	        bike.setRc(rc.getBytes());
	    }

	    if (image != null && !image.isEmpty()) {
	        bike.setImage(image.getBytes());
	    }

	    return bikeServiceImpli.addBike(bike);
	}


	@PatchMapping("/{bikeId}")
	public Bike updateLoanApplicationStatus(@PathVariable Long bikeId, @RequestParam("status") String status) {
		return bikeServiceImpli.editStatus(bikeId, status);
	}

	@PostMapping("/updateBike")
	public Bike updateBike(@RequestParam("bikeId") Long bikeId, @RequestParam("ratePerHour") double ratePerHour, @RequestParam("ratePerDay") double ratePerDay,
			@RequestParam(value = "video", required = false) MultipartFile video) throws IOException {
		Bike bike = bikeServiceImpli.getBikeById(bikeId);
		
		if (video != null && !video.isEmpty()) {
			bike.setVideo(video.getBytes());
		}
		
		RentalRate rr = new RentalRate();
		rr.setRatePerDay(ratePerDay);
		rr.setRatePerHour(ratePerHour);
		RentalRate rentalRate = rentalRateService.addRentalRate(rr);
		
		bike.setRentalRate(rentalRate);
		bike.setStatus("Available");
		return bikeServiceImpli.updateBike(bike);
	}

}
