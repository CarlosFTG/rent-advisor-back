package com.rentadvisor.apirest.services;

import com.rentadvisor.apirest.pojos.HousePojo;
import com.rentadvisor.apirest.pojos.ResponsePojo;

public interface IHousesService {

	ResponsePojo registerHouse(HousePojo housePojo);

}
