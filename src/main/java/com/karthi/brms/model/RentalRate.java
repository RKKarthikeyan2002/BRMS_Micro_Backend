package com.karthi.brms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RentalRate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double ratePerHour;
	private double ratePerDay;

	public RentalRate() {
		super();
	}

	public RentalRate(Long id, double ratePerHour, double ratePerDay) {
		super();
		this.id = id;
		this.ratePerHour = ratePerHour;
		this.ratePerDay = ratePerDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(double ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

	public double getRatePerDay() {
		return ratePerDay;
	}

	public void setRatePerDay(double ratePerDay) {
		this.ratePerDay = ratePerDay;
	}
}
