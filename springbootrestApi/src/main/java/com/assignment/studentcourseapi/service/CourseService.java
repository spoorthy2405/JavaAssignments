package com.assignment.studentcourseapi.service;

import com.assignment.studentcourseapi.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public List<Course> getAll() {
        return courses;
    }

    public Course getById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course updateCourse(int id, Course updated) {
        Course existing = getById(id);
        if (existing != null) {
            existing.setTitle(updated.getTitle());
            existing.setDuration(updated.getDuration());
            existing.setFee(updated.getFee());
        }
        return existing;
    }

    public void deleteCourse(int id) {
        courses.removeIf(c -> c.getId() == id);
    }
}