package com.assignment.employeeprojectapi.repository;

import com.assignment.employeeprojectapi.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}