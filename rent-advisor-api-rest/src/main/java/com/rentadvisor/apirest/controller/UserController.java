package com.rentadvisor.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rentadvisor.apirest.pojos.ResponsePojo;
import com.rentadvisor.apirest.pojos.UserPojo;
import com.rentadvisor.apirest.services.IUserService;

import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/userServices/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity register(@RequestBody UserPojo userPojo) {
		
		//UserPojo userPojo = new UserPojo();
//		userPojo.setName(name);
//		userPojo.setSurname(surname);
//		userPojo.setEmail(email);
//		userPojo.setPassword(pwd);
		
		//User user = new User();
		//user.setUser(username);
		//user.setToken(token);		
		return ResponseEntity.ok( this.userService.register(userPojo));
		
	}
	
	@PostMapping("/userServices/login")
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity login(@RequestBody UserPojo userPojo) {
		
		
		//UserPojo userPojo = new UserPojo();
		userPojo.setEmail(userPojo.getEmail());
		userPojo.setPassword(userPojo.getPassword());
		return ResponseEntity.ok( this.userService.getJWTToken(userPojo));
		
	}
	
	
}
