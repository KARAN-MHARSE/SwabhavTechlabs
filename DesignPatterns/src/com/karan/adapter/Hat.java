package com.karan.adapter;

public class Hat {
	private String shortName;
	private String longName;
	private double basePrice;
	private double tax;

	public Hat(String shortName, String longName, double basePrice, double tax) {
		super();
		this.shortName = shortName;
		this.longName = longName;
		this.basePrice = basePrice;
		this.tax = tax;
	}

	

	public String getShortName() {
		return shortName;
	}



	public String getLongName() {
		return longName;
	}



	public double getBasePrice() {
		return basePrice;
	}



	public double getTax() {
		return tax;
	}



	@Override
	public String toString() {
		return "Hat [shortName=" + shortName + ", longName=" + longName + ", basePrice=" + basePrice + ", tax=" + tax
				+ "]";
	}

}
