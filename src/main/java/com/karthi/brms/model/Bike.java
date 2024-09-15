package com.karthi.brms.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	private String brand;
	private String model;
	private String year;
	private String description;
	private String km;
	private double rating;
	private String status;
	private Date fromDate;
	private Date toDate;

	@Lob
	@Column(length = 1000000, nullable = true)
	private byte[] aadhar;

	@Lob
	@Column(length = 1000000, nullable = true)
	private byte[] rc;

	@Lob
	@Column(length = 1000000, nullable = true)
	private byte[] image;

	@Lob
	@Column(length = 104857600, nullable = true)
	private byte[] video;

	@ManyToOne
	private Customer customer;

	@ManyToOne
	private BikeType bikeType;

	@OneToOne
	private RentalRate rentalRate;

	public Bike() {
		super();
	}

	public Bike(Long id, String number, String brand, String model, String year, String description, String km,
			double rating, String status, Date fromDate, Date toDate, byte[] aadhar, byte[] rc, byte[] image,
			byte[] video, Customer customer, BikeType bikeType, RentalRate rentalRate) {
		super();
		this.id = id;
		this.number = number;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.description = description;
		this.km = km;
		this.rating = rating;
		this.status = status;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.aadhar = aadhar;
		this.rc = rc;
		this.image = image;
		this.video = video;
		this.customer = customer;
		this.bikeType = bikeType;
		this.rentalRate = rentalRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public byte[] getAadhar() {
		return aadhar;
	}

	public void setAadhar(byte[] aadhar) {
		this.aadhar = aadhar;
	}

	public byte[] getRc() {
		return rc;
	}

	public void setRc(byte[] rc) {
		this.rc = rc;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BikeType getBikeType() {
		return bikeType;
	}

	public void setBikeType(BikeType bikeType) {
		this.bikeType = bikeType;
	}

	public RentalRate getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(RentalRate rentalRate) {
		this.rentalRate = rentalRate;
	}
}
