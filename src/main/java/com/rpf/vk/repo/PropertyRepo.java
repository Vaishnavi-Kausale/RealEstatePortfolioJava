package com.rpf.vk.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpf.vk.entity.PropertyEntity;

public interface PropertyRepo extends JpaRepository<PropertyEntity, Long> {

}
