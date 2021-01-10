package com.rentadvisor.apirest.pojos;

import com.rentadvisor.apirest.entities.UserEntity;
import com.vividsolutions.jts.geom.Point;

public class HousePojo {
	Long id;

	private String title;

	private String description;

	private Long ownerId;

	private boolean appreciation;

	private String address;

	private String typology;

	private Point geom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public boolean isAppreciation() {
		return appreciation;
	}

	public void setAppreciation(boolean appreciation) {
		this.appreciation = appreciation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTypology() {
		return typology;
	}

	public void setTypology(String typology) {
		this.typology = typology;
	}

	public Point getGeom() {
		return geom;
	}

	public void setGeom(Point geom) {
		this.geom = geom;
	}
	
	
}
