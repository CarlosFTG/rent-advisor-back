package com.rentadvisor.apirest.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Point;

@Entity
@Table(name = "houses")
public class HouseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511169695675521518L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "title",length=20)
	private String title;
	
	@Column(name = "description",length=200)
	private String description;
	
	@OneToOne(fetch =  FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private UserEntity owner;
	
	@Column(name = "appreciation")
	private boolean appreciation;
	
	@Column(name = "address",length=50)
	private String address;
	
	@Column(name = "typology",length=50)
	private String typology;
	
	@Column(name = "geom",length=20, unique = true)
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

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
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
