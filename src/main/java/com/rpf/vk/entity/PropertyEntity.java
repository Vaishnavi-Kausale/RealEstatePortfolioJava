package com.rpf.vk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PropertyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
    String title;
    double rent;
    double deposite;
    double additionalcharges;
    String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public double getDeposite() {
		return deposite;
	}
	public void setDeposite(double deposite) {
		this.deposite = deposite;
	}
	public double getAdditionalcharges() {
		return additionalcharges;
	}
	public void setAdditionalcharges(double additionalcharges) {
		this.additionalcharges = additionalcharges;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PropertyEntity(String title, double rent, double deposite, double additionalcharges,
			String description) {
		this.title = title;
		this.rent = rent;
		this.deposite = deposite;
		this.additionalcharges = additionalcharges;
		this.description = description;
	}
	public PropertyEntity() {
		
	}
    
    
    
}
