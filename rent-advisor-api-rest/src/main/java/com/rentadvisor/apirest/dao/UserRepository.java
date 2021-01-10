package com.rentadvisor.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentadvisor.apirest.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
}
