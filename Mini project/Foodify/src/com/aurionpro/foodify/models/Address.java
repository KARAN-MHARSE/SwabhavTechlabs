package com.aurionpro.foodify.models;

public class Address {
	private String area;
	private String landmark;
	private String city;
	private String state;
	private String country;
	private int postalCode;
	
	
	public Address(String area, String landmark, int postalCode) {
		this.area = area;
		this.landmark = landmark;
		this.city = "Mumbai";
		this.state = "Maharashtra";
		this.country = "India";
		this.postalCode = postalCode;
	}
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
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
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "Address [area=" + area + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalCode=" + postalCode + "]";
	}
	
	
}
