package com.assignment.studentcourseapi.service;

import com.assignment.studentcourseapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public Student getById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student updateStudent(int id, Student updated) {
        Student existing = getById(id);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setDepartment(updated.getDepartment());
            existing.setCgpa(updated.getCgpa());
        }
        return existing;
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}