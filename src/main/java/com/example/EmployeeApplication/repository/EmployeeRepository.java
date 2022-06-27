package com.example.EmployeeApplication.repository;

import com.example.EmployeeApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
