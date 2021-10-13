package com.westpac.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * This class represents the Geographic location of the blogger's address.
 */

@Entity
public class Geo {

	@Id
	private long id;

	private String lat;

	private String lng;

	@OneToOne
	@MapsId
	@JoinColumn(name = "address_id")
	@JsonBackReference
	private Address address;

	public Geo() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Geo [id=" + id + ", lat=" + lat + ", lng=" + lng + ", address=" + address + "]";
	}

}
