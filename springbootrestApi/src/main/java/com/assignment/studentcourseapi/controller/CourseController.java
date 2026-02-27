package com.assignment.studentcourseapi.controller;

import com.assignment.studentcourseapi.model.Course;
import com.assignment.studentcourseapi.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Course add(@RequestBody Course course) {
        return service.addCourse(course);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteCourse(id);
        return "Course Deleted";
    }
}