package com.rentadvisor.apirest.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rentadvisor.apirest.pojos.HousePojo;
import com.rentadvisor.apirest.pojos.ResponsePojo;
import com.rentadvisor.apirest.pojos.UserPojo;
import com.rentadvisor.apirest.services.IHousesService;
import com.rentadvisor.apirest.services.IUserService;
import com.vividsolutions.jts.io.ParseException;

import org.springframework.http.HttpStatus;

//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class HouseRegistrationController {
	
	//@Autowired
	IHousesService housesService;
	
	//@PostMapping("/houseAdvisorService/registerHouse")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ResponsePojo> registerHouse(@RequestBody  HousePojo housePojo) throws  JSONException, ParseException  {
		
		
//		UserEntity userEntity = null;
//		try {
//			 userEntity = objectMapper.readValue(userpojo, UserEntity.class);
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return ResponseEntity.ok(this.housesService.registerHouse(housePojo));
	}

}
