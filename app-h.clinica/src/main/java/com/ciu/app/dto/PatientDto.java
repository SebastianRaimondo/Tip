package com.ciu.app.dto;

import java.io.Serializable;





public class PatientDto implements Serializable{


	private static final long serialVersionUID = -5075788032511693635L;
	private String name;
	private String surname;
	private Long phoneNumber;
	private String address;
	private Long dni;
	
	public PatientDto(String name, String surname, Long phoneNumber, String address, Long dni) {
		super();
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}

	
	

}
