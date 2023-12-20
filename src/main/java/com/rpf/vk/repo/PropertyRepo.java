package com.rpf.vk.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rpf.vk.entity.PropertyEntity;

public interface PropertyRepo extends JpaRepository<PropertyEntity, Long> {

	Page<PropertyEntity> findAllByPropertystatus(int propertystatus, Pageable pageable);
}
