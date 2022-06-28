package com.example.EmployeeApplication.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Employee {
    //id generator AI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int employeeID;
    String employeeName;
    String employeeCity;

    @OneToOne
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;

    public Employee() {
    }

    public Employee(int employeeID, String employeeName, String employeeCity) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }
}
