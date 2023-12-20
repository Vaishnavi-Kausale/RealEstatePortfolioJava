package com.rpf.vk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rpf.vk.entity.PropertyEntity;
import com.rpf.vk.entity.PropertystatusPojo;
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
	@RequestMapping(method = RequestMethod.GET, value = "/getall/{pageid}")
	Page<PropertyEntity> getPropertyList(@PathVariable int pageid)
	{
		Pageable pageable=PageRequest.of(pageid, 20);
		return propertyrepo.findAllByPropertystatus(0,pageable);
	}
	
	//search property using given query
	
	//add new property
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	PropertyEntity createNewProperty(@RequestBody PropertyEntity obj)
	{
		return propertyrepo.save(obj);
	}
	
	//add new property
	@RequestMapping(method = RequestMethod.POST, value = "/update-property-status")
	PropertyEntity updatePropertystatus(@RequestBody PropertystatusPojo obj)
	{
		PropertyEntity prop_obj = propertyrepo.findById(obj.getPropertyid()).get();
		prop_obj.setPropertystatus(obj.getStatus());
		return propertyrepo.save(prop_obj);
	}
}


