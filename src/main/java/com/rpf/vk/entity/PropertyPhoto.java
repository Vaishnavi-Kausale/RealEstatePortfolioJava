package com.rpf.vk.entity;

import java.sql.Blob;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PropertyPhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	long propertyid;
	Blob image;
	long userid;
	@CreationTimestamp
	LocalDateTime uploadedat;
	public PropertyPhoto(long id,long propertyid, Blob image, long userid, LocalDateTime uploadedat) {
		this.id = id;
		this.propertyid = propertyid;
		this.image = image;
		this.userid = userid;
		this.uploadedat = uploadedat;
	}
	public PropertyPhoto() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(long propertyid) {
		this.propertyid = propertyid;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public LocalDateTime getUploadedat() {
		return uploadedat;
	}
	public void setUploadedat(LocalDateTime uploadedat) {
		this.uploadedat = uploadedat;
	}
	
	
	
	
}
