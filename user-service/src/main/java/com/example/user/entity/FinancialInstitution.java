package com.example.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bank")
public class FinancialInstitution {

	@Id
	@GeneratedValue
	private Integer id;

	private String Bank;

	private Integer Customers;

	private String Country;
	
	private String Location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBank() {
		return Bank;
	}

	public void setBank(String bank) {
		Bank = bank;
	}

	public Integer getCustomers() {
		return Customers;
	}

	public void setCustomers(Integer customers) {
		Customers = customers;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public FinancialInstitution(Integer id, String bank, Integer customers, String country, String location) {
		super();
		this.id = id;
		Bank = bank;
		Customers = customers;
		Country = country;
		Location = location;
	}

	public FinancialInstitution() {
	}

}
