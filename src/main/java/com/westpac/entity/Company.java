package com.westpac.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * This class represents the Company details for a particular user.
 */

@Entity
public class Company {

	@Id
	private long id;

	private String name;

	private String catchPhrase;

	private String bs;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;

	public Company() {
		super();
	}

	public Company(long id, String name, String catchPhrase, String bs, User user) {
		super();
		this.id = id;
		this.name = name;
		this.catchPhrase = catchPhrase;
		this.bs = bs;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", catchPhrase=" + catchPhrase + ", bs=" + bs + ", user=" + user
				+ "]";
	}

}
