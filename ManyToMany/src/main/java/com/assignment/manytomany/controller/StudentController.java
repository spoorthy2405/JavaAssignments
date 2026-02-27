package com.assignment.manytomany.controller;

import com.assignment.manytomany.model.Student;
import com.assignment.manytomany.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @PutMapping("/{studentId}/enroll/{courseId}")
    public Student enroll(@PathVariable Long studentId,
                          @PathVariable Long courseId) {
        return service.enrollCourse(studentId, courseId);
    }
}