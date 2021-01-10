package com.rentadvisor.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.rentadvisor.apirest.dao.HouseRepository;
import com.rentadvisor.apirest.dao.UserRepository;
import com.rentadvisor.apirest.entities.HouseEntity;
import com.rentadvisor.apirest.entities.UserEntity;
import com.rentadvisor.apirest.pojos.HousePojo;
import com.rentadvisor.apirest.pojos.ResponsePojo;

@Service("HousesServiceImpl")
public class HousesServiceImpl implements IHousesService {
	
	@Autowired
	HouseRepository houseRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ResponsePojo registerHouse(HousePojo housePojo) {
		
		ResponsePojo responsePojo = new ResponsePojo();
		HouseEntity houseEntity = new HouseEntity();
		
		houseEntity.setAddress(housePojo.getAddress());
		houseEntity.setTitle(housePojo.getTitle());
		houseEntity.setDescription(housePojo.getDescription());
		houseEntity.setAppreciation(housePojo.isAppreciation());
		houseEntity.setTypology(housePojo.getTypology());
		
		Optional<UserEntity> userEntity = this.userRepository.findById(housePojo.getOwnerId());
		houseEntity.setOwner(userEntity.get());
		
		try {
			this.houseRepository.save(houseEntity);
			responsePojo.setSuccess(true);
			responsePojo.setMessage("Vivienda registrada correctamente");
		}catch(DataAccessException dataAccessException) {
			responsePojo.setSuccess(false);
			responsePojo.setMessage(dataAccessException.getLocalizedMessage());
		}
		
		return responsePojo;
	}

}
