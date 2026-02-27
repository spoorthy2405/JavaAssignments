package com.assignment.manytomany.service;

import com.assignment.manytomany.model.Course;
import com.assignment.manytomany.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    // Create Course
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    // Get All Courses
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    // Get Course By ID
    public Course getCourseById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    // Delete Course
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}