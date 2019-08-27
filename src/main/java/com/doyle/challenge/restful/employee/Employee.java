package com.doyle.challenge.restful.employee;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	private String shortName;
	private String fullName;
	private String dateOfBirth;

	@Embedded
	private Address address;

	// private List<String> phoneNumbers = new ArrayList<>();

	public Employee() {
		super();
	}

	public Employee(Long id, String shortName, String fullName, String dateOfBirth, Address address) {
		super();
		this.id = id;
		this.shortName = shortName;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}