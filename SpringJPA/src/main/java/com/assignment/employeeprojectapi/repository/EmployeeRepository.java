package com.assignment.employeeprojectapi.repository;

import com.assignment.employeeprojectapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}