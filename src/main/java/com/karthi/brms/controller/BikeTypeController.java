package com.karthi.brms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthi.brms.model.BikeType;
import com.karthi.brms.serviceimpli.BikeTypeServiceImpli;

@RestController
@RequestMapping("/bikeType")
@CrossOrigin(origins = "http://localhost:3000")
public class BikeTypeController {
	private BikeTypeServiceImpli bikeTypeServiceImpli;

	public BikeTypeController(BikeTypeServiceImpli bikeTypeServiceImpli) {
		super();
		this.bikeTypeServiceImpli = bikeTypeServiceImpli;
	}

	@GetMapping("/allName")
	public List<String> getAllBikeTypes() {
		return bikeTypeServiceImpli.getAllBikeTypes();
	}
	
	@GetMapping("/{name}")
	public BikeType getBikeTypeById(@PathVariable String name) {
		return bikeTypeServiceImpli.getBikeTypeByName(name);
	}

	@PostMapping("/add")
	public BikeType addBikeType(@RequestBody BikeType bikeType) {
		return bikeTypeServiceImpli.addBikeType(bikeType);
	}

	@PostMapping("/delete")
	public void deleteBikeType(@RequestParam Long id) {
		bikeTypeServiceImpli.deleteBikeType(id);
	}
}