package com.karthi.brms.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	@Column(nullable = true)
	private int hours;
	@Column(nullable = true)
	private Date fromDate;
	@Column(nullable = true)
	private Date toDate;
	private double advance;
	private String advanceStatus;
	private double balance;
	private double totalAmount;
	private String amountStatus;
	private String status;
	private String phone;

	@Lob
	@Column(length = 1000000, nullable = true)
	private byte[] license;

	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Bike bike;

	public Booking() {
		super();
	}

	public Booking(Long id, String name, int age, int hours, Date fromDate, Date toDate, double advance,
			String advanceStatus, double balance, double totalAmount, String amountStatus, String status,
			String phone, byte[] license, Customer customer, Bike bike) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.hours = hours;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.advance = advance;
		this.advanceStatus = advanceStatus;
		this.balance = balance;
		this.totalAmount = totalAmount;
		this.amountStatus = amountStatus;
		this.status = status;
		this.phone = phone; // Initialize phone
		this.license = license;
		this.customer = customer;
		this.bike = bike;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
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

	public double getAdvance() {
		return advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public String getAdvanceStatus() {
		return advanceStatus;
	}

	public void setAdvanceStatus(String advanceStatus) {
		this.advanceStatus = advanceStatus;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAmountStatus() {
		return amountStatus;
	}

	public void setAmountStatus(String amountStatus) {
		this.amountStatus = amountStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getLicense() {
		return license;
	}

	public void setLicense(byte[] license) {
		this.license = license;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}
}
