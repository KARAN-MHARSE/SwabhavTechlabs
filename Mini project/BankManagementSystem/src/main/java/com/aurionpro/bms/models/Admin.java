package com.aurionpro.bms.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Admin {
    private int id;
    private int userId;
    private double salary;
    private Timestamp hireDate;

    public Admin() {}

    public Admin(int id, int userId ,double salary, Timestamp hireDate) {
        this.id = id;
        this.userId = userId;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Timestamp getHireDate() { return hireDate; }
    public void setHireDate(Timestamp hireDate) { this.hireDate = hireDate; }

    @Override
    public String toString() {
        return "Admin{id=" + id + ", userId=" + userId + "', salary=" + salary +
                ", hireDate=" + hireDate + "}";
    }
}

