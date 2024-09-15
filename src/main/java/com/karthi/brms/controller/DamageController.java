package com.karthi.brms.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.karthi.brms.model.Bike;
import com.karthi.brms.model.Damage;
import com.karthi.brms.service.BikeService;
import com.karthi.brms.service.DamageService;

@RestController
@RequestMapping("/damage")
@CrossOrigin(origins = "http://localhost:3000")
public class DamageController {
	DamageService damageService;
	BikeService bikeService;

	public DamageController(DamageService damageService, BikeService bikeService) {
		super();
		this.damageService = damageService;
		this.bikeService = bikeService;
	}
	
	@PostMapping("/add")
    public Damage addDamage(
        @RequestParam("amount") double amount,
        @RequestParam("description") String description,
        @RequestParam("image") MultipartFile image,
        @RequestParam("bike") Long bikeId) throws IOException {
		Bike bike = bikeService.getBikeById(bikeId);
		
		Damage damage = new Damage();
        damage.setAmount(amount);
        damage.setDescription(description);
        damage.setImage(image.getBytes());
        damage.setBike(bike);
        
		return damageService.addDamage(damage);
	}
}
