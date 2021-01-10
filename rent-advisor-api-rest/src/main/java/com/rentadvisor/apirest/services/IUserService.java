package com.rentadvisor.apirest.services;

import com.rentadvisor.apirest.entities.UserEntity;
import com.rentadvisor.apirest.pojos.ResponsePojo;
import com.rentadvisor.apirest.pojos.UserPojo;

public interface IUserService {
	public ResponsePojo register(UserPojo userpojo);
	public ResponsePojo getJWTToken(UserPojo userPojo); 
}
