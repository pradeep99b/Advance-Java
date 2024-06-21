package com.cdac.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	private int personId;

	public PassportInfo getPassportInfo() {
		return passportInfo;
	}

	public void setPassportInfo(PassportInfo passportInfo) {
		this.passportInfo = passportInfo;
	}

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILE_NUMBER")
	private long mobileNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PASSPORT_ID", referencedColumnName = "passportId")
	private PassportInfo passportInfo;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long l) {
		this.mobileNumber = l;
	}
	
	

}
