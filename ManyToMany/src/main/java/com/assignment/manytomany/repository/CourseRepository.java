package com.assignment.manytomany.repository;

import com.assignment.manytomany.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {}