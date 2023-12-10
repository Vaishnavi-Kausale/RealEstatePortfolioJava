package com.rpf.vk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rpf.vk.entity.PropertyEntity;
import com.rpf.vk.repo.PropertyRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "property")
public class PropertyController {

	@Autowired
	PropertyRepo propertyrepo;
	
	//get property details by id
	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	Optional<PropertyEntity> getPropertyById(@PathVariable long id)
	{
		return propertyrepo.findById(id);
	}
	
	//get all property list
	@RequestMapping(method = RequestMethod.GET, value = "/getall")
	List<PropertyEntity> getPropertyList()
	{
		return propertyrepo.findAll();
	}
	
	//search property
	
	//add new property
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	PropertyEntity createNewProperty(@RequestBody PropertyEntity obj)
	{
		return propertyrepo.save(obj);
	}
}
