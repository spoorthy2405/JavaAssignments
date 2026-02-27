package com.assignment.manytomany.repository;

import com.assignment.manytomany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}