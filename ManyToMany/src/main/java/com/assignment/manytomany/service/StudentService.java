package com.assignment.manytomany.service;

import com.assignment.manytomany.model.Course;
import com.assignment.manytomany.model.Student;
import com.assignment.manytomany.repository.CourseRepository;
import com.assignment.manytomany.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student enrollCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        Course course = courseRepo.findById(courseId).orElseThrow();

        student.getCourses().add(course);
        return studentRepo.save(student);
    }
}
