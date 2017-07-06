package com.ttn.web.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserData {

	String firstName;
	String lastName;
	String userId;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	Date dob;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}