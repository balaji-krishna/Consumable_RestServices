package com.project.dogs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Dogs {

	@Id
	private Long dogId;
	
	private String dogName;
	
	private double dogAge;

	public Dogs() {
		super();
	}

	public Dogs(Long dogId, String dogName, double dogAge) {
		super();
		this.dogId = dogId;
		this.dogName = dogName;
		this.dogAge = dogAge;
	}

	public Long getDogId() {
		return dogId;
	}

	public void setDogId(Long dogId) {
		this.dogId = dogId;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public double getDogAge() {
		return dogAge;
	}

	public void setDogAge(double dogAge) {
		this.dogAge = dogAge;
	}

	@Override
	public String toString() {
		return "Dogs [dogId=" + dogId + ", dogName=" + dogName + ", dogAge=" + dogAge + "]";
	}
	
}
