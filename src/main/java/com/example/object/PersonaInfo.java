package com.example.object;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import com.example.util.ColorHair;

public class PersonaInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@Pattern(regexp = "[a-zA-Z]", flags = Flag.UNICODE_CASE)
	private String name;
	@Pattern(regexp = "[a-zA-Z]", flags = Flag.UNICODE_CASE)
	private String lastName;	
	@Pattern(regexp = "^[a-zA-Z0-9 ]*$", flags = Flag.UNICODE_CASE)
	private String address;	
	@Pattern(regexp = "^[1-9]\\d*$", flags = Flag.UNICODE_CASE)
	private Integer phoneNumber;
	private ColorHair colorHair;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ColorHair getColorHair() {
		return colorHair;
	}
	public void setColorHair(ColorHair colorHair) {
		this.colorHair = colorHair;
	}
	
}