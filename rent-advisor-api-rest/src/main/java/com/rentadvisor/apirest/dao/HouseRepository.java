package com.rentadvisor.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentadvisor.apirest.entities.HouseEntity;

public interface HouseRepository extends JpaRepository<HouseEntity, Long> {

}
