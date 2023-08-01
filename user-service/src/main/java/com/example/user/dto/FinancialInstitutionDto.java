package com.example.user.dto;

import org.springframework.stereotype.Component;

@Component
public class FinancialInstitutionDto {

	private String fiName;
	private Integer customers;
	private String location;
	private String country;

	public String getFiName() {
		return fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	public Integer getCustomers() {
		return customers;
	}

	public void setCustomers(Integer customers) {
		this.customers = customers;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public FinancialInstitutionDto(String fiName, Integer customers, String location, String country) {
		super();
		this.fiName = fiName;
		this.customers = customers;
		this.location = location;
		this.country = country;
	}
	
	

	@Override
	public String toString() {
		return "Financial Institution = " + fiName +"\n"
				+ "Customers = " + customers+"\n"
				+" Location = " + location+"\n"
				+ "Country = " + country;
	}

	public FinancialInstitutionDto() {
	}

}
