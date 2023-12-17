package com.rpf.vk.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rpf.vk.entity.PropertyPhoto;

public interface PropertyPhotoRepo extends JpaRepository<PropertyPhoto, Long> {

	@Query(value="select p.id from property_photo p where p.propertyid=?1",nativeQuery = true)
	ArrayList<Long> findByPropertyid(long propertyid);
}
