package com.example.EmployeeApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {
    //id generator Auto Incremented
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int employeeID;
    String employeeName;
    String employeeCity;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;


    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Address> addresses;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinTable(name = "employee_project",
            joinColumns = @JoinColumn(name = "fk_employee"), //JOIN employee ON columns as fk_employee
            inverseJoinColumns = @JoinColumn(name = "fk_project")) //column as fk_project
    private Set<Project> projects = new HashSet<>();

    public Employee() {
    }

    public Employee(String employeeName, String employeeCity) {
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public Employee(int employeeID, String employeeName, String employeeCity, Spouse spouse) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
        this.spouse=spouse;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project){
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Project project)
    {
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public void addAddress(Address address){
        this.addresses=new ArrayList<>();
        this.addresses.add(address);
        address.setEmployee(this);
    }

    public void removeAddress(Address address){
        this.addresses.remove(address);
        address.setEmployee(null);
    }

}
