package com.george.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	public static int ACTIVE_STATUS = 1;
	public static int CANCELLED = 1;
	public static int SUSPENDED = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String name;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String phone;
	private String email;
	private int status = ACTIVE_STATUS;
	
	public User()
	{
		
	}

	public User(long userId, String name, String addressLine1, String addressLine2, String city, String state,
			String country, String phone, String email, int status) {
		super();
		this.userId = userId;
		this.name = name;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
		this.email = email;
		this.status = status;
	}

	public static int getACTIVE_STATUS() {
		return ACTIVE_STATUS;
	}

	public static void setACTIVE_STATUS(int aCTIVE_STATUS) {
		ACTIVE_STATUS = aCTIVE_STATUS;
	}

	public static int getCANCELLED() {
		return CANCELLED;
	}

	public static void setCANCELLED(int cANCELLED) {
		CANCELLED = cANCELLED;
	}

	public static int getSUSPENDED() {
		return SUSPENDED;
	}

	public static void setSUSPENDED(int sUSPENDED) {
		SUSPENDED = sUSPENDED;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", state=" + state + ", country=" + country + ", phone=" + phone
				+ ", email=" + email + ", status=" + status + "]";
	}
}
