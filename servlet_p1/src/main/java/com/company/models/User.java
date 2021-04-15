package com.company.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {
	
	private Long id;
	private String firstname;
	private String secondname;
	private String email;
	private LocalDateTime created_date;
	
	
	public User(String firstname, String secondname, String email, LocalDateTime created_date) {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
		this.email = email;
		this.created_date = created_date;
	}


	public User(Long id, String firstname, String secondname, String email, LocalDateTime created_date) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.secondname = secondname;
		this.email = email;
		this.created_date = created_date;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getSecondname() {
		return secondname;
	}


	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDateTime getCreated_date() {
		return created_date;
	}


	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", secondname=" + secondname + ", email=" + email
				+ ", created_date=" + created_date + "]";
	}
	
	
	
	
	
	
	
	

}
