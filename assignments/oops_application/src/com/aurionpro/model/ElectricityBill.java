package com.aurionpro.model;

public class ElectricityBill {
	private int userId;
	private int billId;
	private int units;
	private String date;
	private String address;

	public ElectricityBill() {
		System.out.println("Welcome in the karan electricity bill.");
	}

	public ElectricityBill(int userId, int billId, int units, String date, String address) {
		this();
		this.userId = userId;
		this.billId = billId;
		this.units = units;
		this.date = date;
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double calculateBill() {
		double totalBill = 0;

		if (units <= 100) {
			totalBill += totalBill * 3.50;
			return totalBill;
		}
		if(units <= 200)	{
			totalBill = (100*3.50) + (units-100)*4.0;
			return totalBill;
//			totalBill+= 100*3.50;
//			units -=100;
//			totalBill+=units*4.0;
		}
		if(units <= 300) {
			totalBill = (100*3.50) + (100*4.0) + (units-100)*5.20;
			return totalBill;
//			totalBill+= 100*3.50;
//			units -=100;
//			totalBill+=100*4.0;
//			units -=100;
//			totalBill += units*5.20;
		} 
			totalBill = (100*3.50) + (100*4.0) + (100*5.20)+ (units-100)*6.5;

//			totalBill+= 100*3.50;
//			units -=100;
//			totalBill+=100*4.0;
//			units -=100;
//			totalBill += 100*5.20;
//			units-=100;
//			totalBill+= units*6.50;
		
		return totalBill;
	}

}
