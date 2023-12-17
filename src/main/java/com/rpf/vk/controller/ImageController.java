package com.rpf.vk.controller;


import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rpf.vk.entity.PropertyEntity;
import com.rpf.vk.entity.PropertyPhoto;
import com.rpf.vk.entity.StatusPojo;
import com.rpf.vk.repo.PropertyPhotoRepo;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "image")
public class ImageController {
	
	@Autowired
	PropertyPhotoRepo propertyphotoRepo;
	
	//get
	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	imageResponsePojo getPhotoById(@PathVariable long id) throws SQLException
	{
		PropertyPhoto propobj= propertyphotoRepo.findById(id).get();
		Blob image = propobj.getImage();
		byte[] bytes = image.getBytes(1,(int) image.length());
		
		return new imageResponsePojo(new String(bytes));
	}
	
	//add new photo
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	StatusPojo upload(@RequestBody PropertyPhotoPojo obj) throws SerialException, SQLException
	{
		PropertyPhoto propobj = new PropertyPhoto();
		propobj.setPropertyid(obj.getPropertyid());
		
		byte[] bytes = obj.image.getBytes(StandardCharsets.UTF_8);
		propobj.setImage(new SerialBlob(bytes));
		
		propertyphotoRepo.save(propobj);
		return new StatusPojo("success", "image uploaded successfully");
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/getpropertyphotolist/{proprtyid}")
	ArrayList<Long> getPhotoIdByPropertyId(@PathVariable long proprtyid)
	{
			return propertyphotoRepo.findByPropertyid(proprtyid);
	}
}

class PropertyPhotoPojo
{
    long propertyid;
	String image;
	public PropertyPhotoPojo(long propertyid, String image) {
		super();
		this.propertyid = propertyid;
		this.image = image;
	}
	public PropertyPhotoPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(long propertyid) {
		this.propertyid = propertyid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}

class imageResponsePojo
{
	String image;

	public imageResponsePojo(String image) {
		super();
		this.image = image;
	}

	public imageResponsePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
