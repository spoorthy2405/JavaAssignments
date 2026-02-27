package com.assignment.manytomany.controller;

import com.assignment.manytomany.model.Course;
import com.assignment.manytomany.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return service.saveCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return service.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
        return "Course Deleted";
    }
}