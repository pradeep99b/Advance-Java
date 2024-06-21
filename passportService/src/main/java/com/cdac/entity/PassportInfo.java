package com.cdac.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PASSPORT_INFO")
public class PassportInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passportId;
	
	@Column(name="ISSUED_BY")
	private String issuedBy;
	
	@Column(name="ISSUED_DATE")
	private LocalDate issueDate;
	
	@Column(name="EXPIRY_DATE")
	private LocalDate expDate;
	
	@Column(name="PERSON_ID")
	private int personId;
	
	
	public int getPassportId() {
		return passportId;
	}
	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}
	public String getIssuedBy() {
		return issuedBy;
	}
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	

}
